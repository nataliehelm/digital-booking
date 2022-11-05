terraform {
  backend "remote" {
    organization = "0521PTC6N2-grupo9"
    workspaces {
      name = "Digital-Booking"
    }
  }
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 4.16"
    }
  }
  required_version = ">= 1.2.0"
}

provider "aws" {
  region = "us-east-2"
}

#Create vpc
resource "aws_vpc" "group9-vpc" {
  cidr_block = "10.0.0.0/16"
  tags = {
    Name = "0521PTC6N2-group9-vpc"
  }
}

#Create Internet Gateway
resource "aws_internet_gateway" "group9-igw" {
  vpc_id = aws_vpc.group9-vpc.id
  tags = {
    Name = "0521PTC6N2-group9-igw"
  }
}

#Create Route Table
resource "aws_route_table" "group9-rt" {
  vpc_id = aws_vpc.group9-vpc.id
  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.group9-igw.id
  }
  route {
    ipv6_cidr_block = "::/0"
    gateway_id      = aws_internet_gateway.group9-igw.id
  }
  tags = {
    Name = "0521PTC6N2-group9-rt"
  }
}

#Create a Subnet
resource "aws_subnet" "group9-sbn" {
  vpc_id            = aws_vpc.group9-vpc.id
  cidr_block        = "10.0.0.0/24"
  availability_zone = "us-east-2a"
  tags = {
    Name = "0521PTC6N2-group9-sbn"
  }
}

#Associate subnet with Route Table
resource "aws_route_table_association" "group9-rt-association" {
  subnet_id      = aws_subnet.group9-sbn.id
  route_table_id = aws_vpc.group9-vpc.main_route_table_id
}

#Create Security Group to allow basics (SSH, HTTP, HTTPS)
resource "aws_security_group" "group9-sg" {
  name        = "0521PTC6N2-group9-sg"
  description = "Allow SSH, HTTP, HTTPS"
  vpc_id      = aws_vpc.group9-vpc.id
  ingress {
    description = "SSH"
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    description = "HTTP"
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    description = "HTTPS"
    from_port   = 443
    to_port     = 443
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

#Create Network Interface with an IP address in the subnet
resource "aws_network_interface" "group9-api-nic" {
  subnet_id       = aws_subnet.group9-sbn.id
  private_ips     = ["10.0.0.50"]
  security_groups = [aws_security_group.group9-sg.id]
  tags = {
    Name = "0521PTC6N2-group9-api-nic"
  }
}

#Assign a public IP address to the network interface
resource "aws_eip" "group9-eip" {
  vpc               = true
  network_interface = aws_network_interface.group9-api-nic.id
  depends_on        = [aws_internet_gateway.group9-igw]
  tags = {
    Name = "0521PTC6N2-group9-eip"
  }
}

#Create an ec2 key pair
resource "aws_key_pair" "group9-key" {
  key_name   = "0521PTC6N2-group9-key"
  public_key = file("~/.ssh/id_rsa.pub")
}

#Create an EC2 instance
resource "aws_instance" "group9-ec2" {
  ami               = "ami-097a2df4ac947655f"
  instance_type     = "t2.micro"
  availability_zone = "us-east-2a"
  key_name          = aws_key_pair.group9-key.key_name
  network_interface {
    network_interface_id = aws_network_interface.group9-api-nic.id
    device_index         = 0
  }
  user_data = <<-EOF
              #!/bin/bash
              sudo apt update -y
              EOF
  tags = {
    Name = "0521PTC6N2-group9-ec2-be-api"
  }
}
