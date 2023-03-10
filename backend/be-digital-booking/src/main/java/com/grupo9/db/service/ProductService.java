package com.grupo9.db.service;

import com.grupo9.db.dto.Auth.JwtDto;
import com.grupo9.db.dto.Image.SaveImageDto;
import com.grupo9.db.dto.Product.GetBookedDatesDto;
import com.grupo9.db.dto.Product.GetProductWithBookingsDto;
import com.grupo9.db.dto.Product.SaveFullProductDto;
import com.grupo9.db.dto.Product.SaveProductDto;
import com.grupo9.db.dto.SubPolicy.SaveSubPolicyDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;
import com.grupo9.db.security.jwt.JwtUtils;
import com.grupo9.db.util.ObjectMapperUtils;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private AmazonClient amazonClient;

    private final IProductRepository repository;
    private final ICategoryRepository categoryRepository;
    private final ILocationRepository locationRepository;
    private final IUserRepository userRepository;
    private final IFeatureRepository featureRepository;
    private final IPolicyRepository policyRepository;
    private final IBookingRepository bookingRepository;
    private final ISubPolicyRepository subPolicyRepository;
    private final IImageRepository iImageRepository;
    private ResponsesBuilder responsesBuilder;

    public ProductService(BookingService bookingService, AmazonClient amazonClient, IProductRepository repository, ICategoryRepository categoryRepository, ILocationRepository locationRepository, IUserRepository userRepository, IFeatureRepository featureRepository, IPolicyRepository policyRepository, IBookingRepository bookingRepository, ISubPolicyRepository subPolicyRepository, IImageRepository iImageRepository, ResponsesBuilder responsesBuilder) {
        this.bookingService = bookingService;
        this.amazonClient = amazonClient;
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
        this.featureRepository = featureRepository;
        this.policyRepository = policyRepository;
        this.bookingRepository = bookingRepository;
        this.subPolicyRepository = subPolicyRepository;
        this.iImageRepository = iImageRepository;
        this.responsesBuilder = responsesBuilder;
    }

    public Page<Product> findAll(String token, Pageable pageable){
        if(token != null){
            return repository.findByOrderByIdAsc(pageable);
        }
        return repository.findAllRandom(pageable);
        }

    public Page<Product> findByUser(String token, Pageable pageable) throws BadRequestException, ResourceNotFoundException {
        if(token == null){
            throw new BadRequestException("Token invalido");
        }
        JwtUtils jwtUtils = new JwtUtils();

        JwtDto jwtDto = jwtUtils.getDecodedJwt(token);

        Optional<User> user = userRepository.findById(jwtDto.getUserId());
        if(user.isEmpty()){
            throw new ResourceNotFoundException("User with id " + jwtDto.getUserId() + " not found");
        }

        return repository.findByUser(user.get(), pageable);
    }


    public Product findById(Long id) throws ResourceNotFoundException {
        Optional<Product> product = repository.findById(id);
        if(product.isEmpty()){
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        }
        return product.get();
    }

    public Page<Product> findAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public GetProductWithBookingsDto findByIdWithBookings(Long id) throws ResourceNotFoundException {
        Optional<Product> product = repository.findById(id);
        if(product.isEmpty()){
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        }

        List<Booking> bookings = bookingService.findAllBookingsByProductId(id);
        List<GetBookedDatesDto> listOfBookedDates = null;

        if(bookings.get(0) != null){
            listOfBookedDates = ObjectMapperUtils.mapAll(bookings, GetBookedDatesDto.class);
            for (GetBookedDatesDto booking: listOfBookedDates){
                LocalDate startingDate = LocalDate.parse(booking.getStarting_date().toString());
                LocalDate endingDate = LocalDate.parse(booking.getEnding_date().toString());
                List<LocalDate> bookedDates = startingDate.datesUntil(endingDate.plusDays(1)).collect(Collectors.toList());
                booking.setBooked_dates(bookedDates);
            }

        }

        GetProductWithBookingsDto response = new GetProductWithBookingsDto(product.get(), listOfBookedDates);
        return response;
    }

    public Page<Product> findByParams(Map<String, String> params, Pageable pageable) throws ResourceNotFoundException, BadRequestException {
        if(params.get("locationId") != null && params.get("categoryId") != null){
            Long locationId = Long.valueOf(params.get("locationId"));
            Optional<Location> location = locationRepository.findById(locationId);
            if(location.isEmpty()){
                throw new ResourceNotFoundException("Location with id " + locationId + " not found");
            }
            String[] categoryIds = (params.get("categoryId")).split(",");
            List<Category> categories = new ArrayList<>();
            for (String id:categoryIds) {
                Optional<Category> category = categoryRepository.findById(Long.valueOf(id));
                if(category.isEmpty()){
                    throw new ResourceNotFoundException("Category with id " + id + " not found");
                }
                categories.add(category.get());
            }
                return repository.findByLocationAndCategoryIn(location.get(), categories, pageable);
        }
        if(params.get("categoryId") != null){
            String[] categoryIds = (params.get("categoryId")).split(",");
            List<Category> categories = new ArrayList<>();
            for (String id:categoryIds) {
                Optional<Category> category = categoryRepository.findById(Long.valueOf(id));
                if(category.isEmpty()){
                    throw new ResourceNotFoundException("Category with id " + id + " not found");
                }
                categories.add(category.get());
            }
            return repository.findByCategoryIn(categories, pageable);

        }
        if(params.get("locationId") != null){
            Long locationId = Long.valueOf(params.get("locationId"));
            Optional<Location> location = locationRepository.findById(locationId);
            if(location.isEmpty()){
                throw new ResourceNotFoundException("Location with id " + locationId + " not found");
            }
            return repository.findByLocation(location.get(), pageable);
        }

        if(params.get("startingDate") != null && params.get("endingDate") != null){
            String startingDate = params.get("startingDate");
            String endingDate = params.get("endingDate");
            return repository.findAllByStartingDateAndEndingDate(startingDate, endingDate, pageable);
        }

        if(params.get("starting_date") != null && params.get("ending_date") != null && params.get("locationId") != null){
            String startingDate = params.get("startingDate");
            String endingDate = params.get("endingDate");
            String locationId = params.get("locationId");
            Optional<Location> location = locationRepository.findById(Long.valueOf(locationId));
            if(location.isEmpty()){
                throw new ResourceNotFoundException("Location with id " + locationId + " not found");
            }
            return repository.findAllByStartingDateAndEndingDateAndLocation(locationId, startingDate, endingDate, pageable);
        }

        throw new BadRequestException("Invalid Params");
    }

    public Product saveBasic(SaveProductDto productDto) throws ResourceNotFoundException {
        Product product = productBuilder(productDto, null);
        return repository.save(product);
    }

    public Product save(SaveFullProductDto productDto) throws ResourceNotFoundException, BadRequestException {
        SaveProductDto saveProductDto = new SaveProductDto(productDto.getName(), productDto.getDistance_to_nearest_tourist_site(), productDto.getRanking(), productDto.getScore(), productDto.getDescription_title(), productDto.getDescription(), productDto.getCoordinates(), productDto.getCategoryId(), productDto.getLocationId(), productDto.getAddress(), productDto.getFeatureIds(), productDto.getUserId());
        Product product = productBuilder(saveProductDto, null);
        Product newProduct = repository.save(product);
        return fullProductBuilder(productDto, newProduct);
    }

    public Product update(Long id, SaveProductDto productDto) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        }

        Product product = productBuilder(productDto, id);
        return repository.save(product);
    }

    public void deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        }

        repository.deleteById(id);
        }

    private Product productBuilder (SaveProductDto productDto, Long id) throws ResourceNotFoundException {

        Optional<Category> category = categoryRepository.findById(productDto.getCategoryId());
        if(category.isEmpty()){
            throw new ResourceNotFoundException("Category with id " + productDto.getCategoryId() + " not found");
        }
        Optional<Location> location = locationRepository.findById(productDto.getLocationId());
        if(location.isEmpty()){
            throw new ResourceNotFoundException("Location with id " + productDto.getLocationId() + " not found");
        }
        Optional<User> user = userRepository.findById(productDto.getUserId());
        if(user.isEmpty()){
            throw new ResourceNotFoundException("User with id " + productDto.getUserId() + " not found");
        }

        List<Feature> features = new ArrayList<>();
        for(Long featureId:productDto.getFeatureIds()){
            Optional<Feature> feature = featureRepository.findById(featureId);
            if(feature.isEmpty()){
                throw new ResourceNotFoundException("Feature with id " + featureId + " not found");
            }
            features.add(feature.get());
        }

        if(id != null){
            return new Product(id, productDto.getName(), productDto.getDistance_to_nearest_tourist_site(), productDto.getRanking(), productDto.getScore(), productDto.getDescription_title(), productDto.getDescription(), productDto.getCoordinates(), category.get(), location.get(), productDto.getAddress(), features, user.get());
        }

        return new Product(productDto.getName(), productDto.getDistance_to_nearest_tourist_site(), productDto.getRanking(), productDto.getScore(), productDto.getDescription_title(), productDto.getDescription(), productDto.getCoordinates(), category.get(), location.get(), productDto.getAddress(), features, user.get());
    }

    private Product fullProductBuilder (SaveFullProductDto productDto, Product product) throws ResourceNotFoundException, BadRequestException {
        for(SaveSubPolicyDto subPolicyDto:productDto.getSubPolicies()){
            Optional<Policy> policy = policyRepository.findById(subPolicyDto.getPolicy_id());
            if(policy.isEmpty()){
                throw new ResourceNotFoundException("Policy with id " + subPolicyDto.getPolicy_id() + " not found");
            }
            SubPolicy subPolicy = new SubPolicy(subPolicyDto.getDescription(), product, policy.get());
            subPolicyRepository.save(subPolicy);
        }

        for(SaveImageDto imageDto:productDto.getImages()){
            Image image = new Image(imageDto.getTitle(), imageDto.getUrl(), product);
            iImageRepository.save(image);
        }

        return findById(product.getId());
    }
}
