import { render, screen } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import ProductList from './ProductList';

describe('<ProductList />', () => {
  test('Should render the component', () => {
    render(
      <BrowserRouter>
        <ProductList products={products} isLoading={false} />
      </BrowserRouter>
    );
    expect(screen.getAllByRole('listitem')).toHaveLength(8);
  });
  test('should show a figure when isLoading is true', () => {
    render(
      <BrowserRouter>
        <ProductList products={products} isLoading={true} />
      </BrowserRouter>
    );
    expect(screen.getByRole('figure')).toBeInTheDocument();
  });
});

const products = [
  {
    id: 6,
    name: 'Wyndham Garden Ushuaia Hotel del Glaciar',
    distance_to_nearest_tourist_site: 'A 3 KM del centro de Ushuaia',
    ranking: 4.0,
    score: 7.9,
    description_title: 'Despiertate con el glaciar',
    description:
      'Este hotel está ubicado a los pies del glaciar Martial, a solo 3 km del centro de Ushuaia, y ofrece habitaciones con vistas al glaciar o a la bahía, WiFi pública gratuita y aparcamiento privado gratuito.\n\n Cada habitación del Hotel Del Glaciar es amplia y cuenta con ventanales y detalles en madera. Todos los alojamientos están equipados con TV y baño privado.\n\n El restaurante del establecimiento Del Glacier sirve platos internacionales y regionales. Los huéspedes pueden tomar un cóctel junto a la chimenea del vestíbulo del hotel. La recepción está disponible las 24 horas.',
    coordinates: [-54.804290710042714, -68.35730507941658],
    category: {
      id: 1,
      name: 'Hoteles',
      description: '807.105 hoteles',
      image_url:
        'https://images.unsplash.com/photo-1566073771259-6a8506099945?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80',
    },
    location: {
      id: 24,
      province_name: 'Provincia de Tierra del Fuego',
      city_name: 'Ushuaia',
      country_name: 'Argentina',
    },
    features: [
      {
        id: 1,
        name: 'Cocina',
        icon: 'fa-solid fa-kitchen-set',
      },
      {
        id: 2,
        name: 'Aire acondicionado',
        icon: 'fa-regular fa-snowflake',
      },
      {
        id: 3,
        name: 'Estacionamiento gratuito',
        icon: 'fa-solid fa-car',
      },
      {
        id: 4,
        name: 'Wifi',
        icon: 'fa-solid fa-wifi',
      },
      {
        id: 5,
        name: 'Televisor',
        icon: 'fa-solid fa-tv',
      },
    ],
    policies: [
      {
        id: 1,
        title: 'Normas de la casa',
        subPolicies: [
          {
            id: 1,
            description: 'Check-out: 10:00',
          },
          {
            id: 2,
            description: 'No se permiten fiestas',
          },
          {
            id: 3,
            description: 'No fumar',
          },
        ],
      },
      {
        id: 2,
        title: 'Salud y seguridad',
        subPolicies: [
          {
            id: 4,
            description:
              'Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus',
          },
          {
            id: 5,
            description: 'Detector de humo',
          },
          {
            id: 6,
            description: 'Depósito de seguridad',
          },
        ],
      },
      {
        id: 3,
        title: 'Política de cancelación',
        subPolicies: [
          {
            id: 7,
            description:
              'Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.',
          },
        ],
      },
    ],
    images: [
      {
        id: 29,
        title: 'Wyndham Hotel 1',
        url: 'https://images.unsplash.com/photo-1629140727571-9b5c6f6267b4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=627&q=80',
      },
      {
        id: 30,
        title: 'Wyndham Hotel 2',
        url: 'https://images.unsplash.com/photo-1566665797739-1674de7a421a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80',
      },
      {
        id: 31,
        title: 'Wyndham Hotel 3',
        url: 'https://images.unsplash.com/photo-1630660664869-c9d3cc676880?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80',
      },
      {
        id: 32,
        title: 'Wyndham Hotel 4',
        url: 'https://images.unsplash.com/photo-1586105251261-72a756497a11?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=958&q=80',
      },
      {
        id: 33,
        title: 'Wyndham Hotel 5',
        url: 'https://images.unsplash.com/photo-1595576508898-0ad5c879a061?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80',
      },
    ],
  },
  {
    id: 9,
    name: 'Hotel Casino Magic',
    distance_to_nearest_tourist_site: 'A 4,8 km del centro',
    ranking: 5.0,
    score: 9.0,
    description_title:
      'Descubre cómo se sienten las estrellas con el mejor servicio en el Hotel Casino Magic',
    description:
      'El Hotel Casino Magic de Neuquén cuenta con una elegante entrada con arcos y un patio interior con pilares en torno a una piscina al aire libre alargada, y también dispone de spa, casino y conexión Wi-Fi gratuita. El Museo Nacional de Bellas Artes está a 4 km.',
    coordinates: [-38.957918522737856, -68.11447964631512],
    category: {
      id: 1,
      name: 'Hoteles',
      description: '807.105 hoteles',
      image_url:
        'https://images.unsplash.com/photo-1566073771259-6a8506099945?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80',
    },
    location: {
      id: 2,
      province_name: 'Provincia de San Luis',
      city_name: 'San Luis',
      country_name: 'Argentina',
    },
    features: [
      {
        id: 7,
        name: 'Pileta',
        icon: 'fa-solid fa-person-swimming',
      },
      {
        id: 3,
        name: 'Estacionamiento gratuito',
        icon: 'fa-solid fa-car',
      },
      {
        id: 4,
        name: 'Wifi',
        icon: 'fa-solid fa-wifi',
      },
      {
        id: 8,
        name: 'Habitaciones familiares',
        icon: 'fa-solid fa-people-group',
      },
      {
        id: 9,
        name: 'Bar',
        icon: 'fa-solid fa-martini-glass',
      },
    ],
    policies: [
      {
        id: 1,
        title: 'Normas de la casa',
        subPolicies: [
          {
            id: 1,
            description: 'Check-out: 10:00',
          },
          {
            id: 2,
            description: 'No se permiten fiestas',
          },
          {
            id: 3,
            description: 'No fumar',
          },
        ],
      },
      {
        id: 2,
        title: 'Salud y seguridad',
        subPolicies: [
          {
            id: 4,
            description:
              'Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus',
          },
          {
            id: 5,
            description: 'Detector de humo',
          },
          {
            id: 6,
            description: 'Depósito de seguridad',
          },
        ],
      },
      {
        id: 3,
        title: 'Política de cancelación',
        subPolicies: [
          {
            id: 7,
            description:
              'Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.',
          },
        ],
      },
    ],
    images: [
      {
        id: 44,
        title: 'Hotel Casino Magic 1',
        url: 'https://cf.bstatic.com/xdata/images/hotel/max1280x900/25406927.jpg?k=1fa63f199fdcfd819f85625a911f073be33ba86c02b8a2ea9887a591b52feb6d&o=&hp=1',
      },
      {
        id: 45,
        title: 'Hotel Casino Magic 2',
        url: 'https://casinomagic.com.ar/wp-content/uploads/2014/01/1036_hotel-magic.jpg',
      },
      {
        id: 46,
        title: 'Hotel Casino Magic 3',
        url: 'https://casinomagic.com.ar/wp-content/uploads/2014/01/JCR6784.jpg',
      },
      {
        id: 47,
        title: 'Hotel Casino Magic 4',
        url: 'https://casinomagic.com.ar/wp-content/uploads/2014/01/Institucional_0424.jpg',
      },
      {
        id: 48,
        title: 'Hotel Casino Magic 5',
        url: 'https://casinomagic.com.ar/wp-content/uploads/2014/01/1060_hotel-magic.jpg',
      },
    ],
  },
  {
    id: 10,
    name: 'Hostel Danny',
    distance_to_nearest_tourist_site: 'A  200 m del centro',
    ranking: 0.0,
    score: 0.0,
    description_title:
      'Puedes cancelar más tarde. Aprovecha y consigue un buen precio hoy.',
    description:
      'El Hostel Danny ofrece alojamiento con WiFi gratuita en todas las instalaciones en El Calafate, a 5 km del lago Argentino y a 800 metros del Museo Regional. El establecimiento está a 1,6 km de la estación de autobuses de El Calafate, a 2,2 km de la laguna de Nimez y a 8,8 km de la isla Solitaria. Hay servicio de conserjería, mostrador de información turística y servicio de cambio de divisa.',
    coordinates: [-50.33664055279568, -72.2629555017608],
    category: {
      id: 2,
      name: 'Hostels',
      description: '807.105 hoteles',
      image_url:
        'https://images.unsplash.com/photo-1582719508461-905c673771fd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1925&q=80',
    },
    location: {
      id: 5,
      province_name: 'Provincia de Santa Cruz',
      city_name: 'Río Gallegos',
      country_name: 'Argentina',
    },
    features: [
      {
        id: 4,
        name: 'Wifi',
        icon: 'fa-solid fa-wifi',
      },
      {
        id: 10,
        name: 'Habitaciones sin humo',
        icon: 'fa-solid fa-ban-smoking',
      },
      {
        id: 11,
        name: 'Calefacción',
        icon: 'fa-solid fa-temperature-half',
      },
    ],
    policies: [
      {
        id: 1,
        title: 'Normas de la casa',
        subPolicies: [
          {
            id: 1,
            description: 'Check-out: 10:00',
          },
          {
            id: 2,
            description: 'No se permiten fiestas',
          },
          {
            id: 3,
            description: 'No fumar',
          },
        ],
      },
      {
        id: 2,
        title: 'Salud y seguridad',
        subPolicies: [
          {
            id: 4,
            description:
              'Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus',
          },
          {
            id: 5,
            description: 'Detector de humo',
          },
          {
            id: 6,
            description: 'Depósito de seguridad',
          },
        ],
      },
      {
        id: 3,
        title: 'Política de cancelación',
        subPolicies: [
          {
            id: 7,
            description:
              'Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.',
          },
        ],
      },
    ],
    images: [
      {
        id: 49,
        title: 'Hostel Danny 1',
        url: 'https://images.unsplash.com/photo-1623625434462-e5e42318ae49?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80',
      },
      {
        id: 50,
        title: 'Hostel Danny 2',
        url: 'https://images.unsplash.com/photo-1555854877-bab0e564b8d5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1169&q=80',
      },
      {
        id: 51,
        title: 'Hostel Danny 3',
        url: 'https://images.unsplash.com/photo-1626265774643-f1943311a86b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80',
      },
      {
        id: 52,
        title: 'Hostel Danny 4',
        url: ' https://cf.bstatic.com/xdata/images/hotel/max1024x768/399464424.jpg?k=dc3bf1c11aea33a3146025556de6a0ca97d4ad95ecd2ddf8150eaa87ba730ff2&o=&hp=1',
      },
      {
        id: 53,
        title: 'Hostel Danny 5',
        url: 'http://res.cloudinary.com/hostelling-internation/image/upload/f_auto,q_auto/v1565973406/kwunkr44mtjdrqrzz3s7.jpg',
      },
    ],
  },
  {
    id: 12,
    name: 'La Paula bed & breakfast',
    distance_to_nearest_tourist_site: 'A  14,2 km del centro',
    ranking: 4.0,
    score: 8.0,
    description_title: 'Habitación Doble con vistas - 2 camas',
    description:
      'La Paula bed & breakfast se encuentra en San Luis, a 1,9 km del circuito internacional de Potrero de los Funes, y ofrece vistas a la montaña, WiFi gratuita y aparcamiento privado gratuito.\n\n El baño privado está totalmente equipado con ducha y artículos de aseo gratuitos.\n\n El hipódromo Rosendo Hernández se encuentra a 32 km del bed and breakfast, mientras que Potrero de los Funes está a 1 km. El aeropuerto Brigadier Mayor Cesar R. Ojeda es el más cercano y está a 21 km de La Paula bed & breakfast.',
    coordinates: [-33.21144477804261, -66.22836017303051],
    category: {
      id: 4,
      name: 'Bed and breakfast',
      description: '807.105 hoteles',
      image_url:
        'https://images.unsplash.com/photo-1584132905271-512c958d674a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80',
    },
    location: {
      id: 2,
      province_name: 'Provincia de San Luis',
      city_name: 'San Luis',
      country_name: 'Argentina',
    },
    features: [
      {
        id: 10,
        name: 'Habitaciones sin humo',
        icon: 'fa-solid fa-ban-smoking',
      },
      {
        id: 3,
        name: 'Estacionamiento gratuito',
        icon: 'fa-solid fa-car',
      },
      {
        id: 4,
        name: 'Wifi',
        icon: 'fa-solid fa-wifi',
      },
      {
        id: 8,
        name: 'Habitaciones familiares',
        icon: 'fa-solid fa-people-group',
      },
    ],
    policies: [
      {
        id: 1,
        title: 'Normas de la casa',
        subPolicies: [
          {
            id: 1,
            description: 'Check-out: 10:00',
          },
          {
            id: 2,
            description: 'No se permiten fiestas',
          },
          {
            id: 3,
            description: 'No fumar',
          },
        ],
      },
      {
        id: 2,
        title: 'Salud y seguridad',
        subPolicies: [
          {
            id: 4,
            description:
              'Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus',
          },
          {
            id: 5,
            description: 'Detector de humo',
          },
          {
            id: 6,
            description: 'Depósito de seguridad',
          },
        ],
      },
      {
        id: 3,
        title: 'Política de cancelación',
        subPolicies: [
          {
            id: 7,
            description:
              'Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.',
          },
        ],
      },
    ],
    images: [
      {
        id: 59,
        title: 'La Paula bed & breakfast 1',
        url: 'https://images.unsplash.com/photo-1664361238207-164532d1934e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80',
      },
      {
        id: 60,
        title: 'La Paula bed & breakfast 2',
        url: 'https://images.unsplash.com/photo-1431905673613-8b0122cb1196?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80',
      },
      {
        id: 61,
        title: 'La Paula bed & breakfast 3',
        url: 'https://images.unsplash.com/photo-1462530260150-162092dbf011?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1086&q=80',
      },
      {
        id: 62,
        title: 'La Paula bed & breakfast 4',
        url: 'https://images.unsplash.com/photo-1576095910326-9de5a8b207e4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1331&q=80',
      },
      {
        id: 63,
        title: 'La Paula bed & breakfast 5',
        url: 'https://images.unsplash.com/photo-1623114112821-08b8c8d4e42d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80',
      },
    ],
  },
  {
    id: 11,
    name: 'Heaven Catedral',
    distance_to_nearest_tourist_site: 'A  11,5 km del centro',
    ranking: 4.0,
    score: 8.5,
    description_title: 'Apartamento de 1 dormitorio',
    description:
      'El HEAVEN CATEDRAL se encuentra en San Carlos de Bariloche, a 18 km del centro cívico, y ofrece vistas a la piscina, WiFi gratuita y aparcamiento privado gratuito. El alojamiento cuenta con bañera de hidromasaje.\n\n Todos los alojamientos cuentan con zona de estar, sofá, TV de pantalla plana vía satélite y cocina totalmente equipada con zona de comedor. Hay microondas, nevera, horno, hervidor de agua y cafetera.\n\n Todas las mañanas se sirve un desayuno continental y a la carta.',
    coordinates: [-41.16813961310178, -71.43951430203818],
    category: {
      id: 3,
      name: 'Departamentos',
      description: '807.105 hoteles',
      image_url:
        'https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1980&q=80',
    },
    location: {
      id: 6,
      province_name: 'Provincia de Río Negro',
      city_name: 'Viedma',
      country_name: 'Argentina',
    },
    features: [
      {
        id: 7,
        name: 'Pileta',
        icon: 'fa-solid fa-person-swimming',
      },
      {
        id: 10,
        name: 'Habitaciones sin humo',
        icon: 'fa-solid fa-ban-smoking',
      },
      {
        id: 3,
        name: 'Estacionamiento gratuito',
        icon: 'fa-solid fa-car',
      },
      {
        id: 4,
        name: 'Wifi',
        icon: 'fa-solid fa-wifi',
      },
    ],
    policies: [
      {
        id: 1,
        title: 'Normas de la casa',
        subPolicies: [
          {
            id: 1,
            description: 'Check-out: 10:00',
          },
          {
            id: 2,
            description: 'No se permiten fiestas',
          },
          {
            id: 3,
            description: 'No fumar',
          },
        ],
      },
      {
        id: 2,
        title: 'Salud y seguridad',
        subPolicies: [
          {
            id: 4,
            description:
              'Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus',
          },
          {
            id: 5,
            description: 'Detector de humo',
          },
          {
            id: 6,
            description: 'Depósito de seguridad',
          },
        ],
      },
      {
        id: 3,
        title: 'Política de cancelación',
        subPolicies: [
          {
            id: 7,
            description:
              'Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.',
          },
        ],
      },
    ],
    images: [
      {
        id: 54,
        title: 'Heaven Catedral 1',
        url: 'https://pix10.agoda.net/hotelImages/14090026/0/4ae319e43ccf884ad991b4ea2a3a995b.jpg?ca=14&ce=1&s=1024x768',
      },
      {
        id: 55,
        title: 'Heaven Catedral 2',
        url: 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/236658489.jpg?k=a3ee99d083c0fed1b6817ef446b20d655e825f3371153e6dbc19d7b1857e7a4f&o=&hp=1',
      },
      {
        id: 56,
        title: 'Heaven Catedral 3',
        url: 'https://cf.bstatic.com/xdata/images/hotel/max1280x900/237183718.jpg?k=22559619e681a686125474403ed5142dd8f607c5223f955eb87af79a6aa96915&o=&hp=1',
      },
      {
        id: 57,
        title: 'Heaven Catedral 4',
        url: 'https://www.michaycatedral.com.ar/nueva/wp-content/uploads/2020/02/7-6.jpg',
      },
      {
        id: 58,
        title: 'Heaven Catedral 5',
        url: 'https://images.unsplash.com/photo-1517404656827-b10222b9ec59?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1169&q=80',
      },
    ],
  },
  {
    id: 7,
    name: 'Corrientes Plaza Hostel',
    distance_to_nearest_tourist_site: 'A 450 metros del centro',
    ranking: 3.9,
    score: 7.0,
    description_title: 'Todo Corrientes cerca a ti',
    description:
      'El Corrientes Plaza Hotel se encuentra en el centro de Corrientes y dispone de jardín con piscina, centro de fitness y habitaciones elegantes con WiFi gratuita. El desayuno está incluido en la tarifa. El establecimiento está a 2 km de un paseo que discurre junto al río.\n\n Las habitaciones del Corrientes Plaza están totalmente enmoquetadas y decoradas con colores suaves. Todas ellas cuentan con televisión por cable, aire acondicionado y calefacción. Algunas incluyen balcón privado con vistas al jardín.\n\n El Corrientes Plaza Hotel se encuentra a 5 km de la estación de autobuses y a 10 km del aeropuerto Piragine Niveyro.',
    coordinates: [-27.4680280084071, -58.83125194016978],
    category: {
      id: 2,
      name: 'Hostels',
      description: '807.105 hoteles',
      image_url:
        'https://images.unsplash.com/photo-1582719508461-905c673771fd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1925&q=80',
    },
    location: {
      id: 14,
      province_name: 'Provincia de Corrientes',
      city_name: 'Corrientes',
      country_name: 'Argentina',
    },
    features: [
      {
        id: 1,
        name: 'Cocina',
        icon: 'fa-solid fa-kitchen-set',
      },
      {
        id: 2,
        name: 'Aire acondicionado',
        icon: 'fa-regular fa-snowflake',
      },
      {
        id: 3,
        name: 'Estacionamiento gratuito',
        icon: 'fa-solid fa-car',
      },
      {
        id: 4,
        name: 'Wifi',
        icon: 'fa-solid fa-wifi',
      },
    ],
    policies: [
      {
        id: 1,
        title: 'Normas de la casa',
        subPolicies: [
          {
            id: 1,
            description: 'Check-out: 10:00',
          },
          {
            id: 2,
            description: 'No se permiten fiestas',
          },
          {
            id: 3,
            description: 'No fumar',
          },
        ],
      },
      {
        id: 2,
        title: 'Salud y seguridad',
        subPolicies: [
          {
            id: 4,
            description:
              'Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus',
          },
          {
            id: 5,
            description: 'Detector de humo',
          },
          {
            id: 6,
            description: 'Depósito de seguridad',
          },
        ],
      },
      {
        id: 3,
        title: 'Política de cancelación',
        subPolicies: [
          {
            id: 7,
            description:
              'Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.',
          },
        ],
      },
    ],
    images: [
      {
        id: 34,
        title: 'Corrientes Plaza Hostel 1',
        url: 'https://images.unsplash.com/photo-1631049421450-348ccd7f8949?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80',
      },
      {
        id: 35,
        title: 'Corrientes Plaza Hostel 2',
        url: 'https://images.unsplash.com/photo-1610392734074-02f696fd30a8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80',
      },
      {
        id: 36,
        title: 'Corrientes Plaza Hostel 3',
        url: 'https://images.unsplash.com/photo-1609766857041-ed402ea8069a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80',
      },
      {
        id: 37,
        title: 'Corrientes Plaza Hostel 4',
        url: 'https://images.unsplash.com/photo-1562438668-bcf0ca6578f0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1160&q=80',
      },
      {
        id: 38,
        title: 'Corrientes Plaza Hostel 5',
        url: 'https://images.unsplash.com/photo-1578898886225-c7c894047899?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80',
      },
    ],
  },
  {
    id: 2,
    name: 'Chalten Suites Hostel',
    distance_to_nearest_tourist_site: 'A 100 m de la plaza principal',
    ranking: 4.0,
    score: 9.0,
    description_title:
      'Este hotel se encuentra en la mejor zona de El Chaltén y tiene un puntaje excelente por la ubicación.',
    description:
      'Este alojamiento se encuentra en El Chalten, a 100 metros de la plaza principal. Ofrece habitaciones acogedoras y elegantes y conexión wifi gratis. El Chalten Suites tiene una zona de desayunos amplia, con muchas ventanas y vistas al jardín y las montañas de los alrededores.\n\nEl Chalten Suites Hotel dispone de habitaciones con TV y minibar. El baño privado incluye ducha y secador de pelo. Todas tienen escritorio.\n\nEl Chalten Suite cuenta con mostrador de información turística y consigna de equipaje.\n\nEl alojamiento cuenta con estacionamiento gratuito. Está a 200 metros del río Fitz Roy y a 210 km del aeropuerto de El Calafate.\n\nNuestros clientes dicen que esta parte de El Chaltén es su favorita, según los comentarios independientes.\n\nA las parejas les gusta la ubicación. Le pusieron un puntaje de 9,6 para un viaje de a dos.',
    coordinates: [-49.330412, -72.888143],
    category: {
      id: 2,
      name: 'Hostels',
      description: '807.105 hoteles',
      image_url:
        'https://images.unsplash.com/photo-1582719508461-905c673771fd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1925&q=80',
    },
    location: {
      id: 5,
      province_name: 'Provincia de Santa Cruz',
      city_name: 'Río Gallegos',
      country_name: 'Argentina',
    },
    features: [
      {
        id: 4,
        name: 'Wifi',
        icon: 'fa-solid fa-wifi',
      },
      {
        id: 3,
        name: 'Estacionamiento gratuito',
        icon: 'fa-solid fa-car',
      },
    ],
    policies: [
      {
        id: 1,
        title: 'Normas de la casa',
        subPolicies: [
          {
            id: 1,
            description: 'Check-out: 10:00',
          },
          {
            id: 2,
            description: 'No se permiten fiestas',
          },
          {
            id: 3,
            description: 'No fumar',
          },
        ],
      },
      {
        id: 2,
        title: 'Salud y seguridad',
        subPolicies: [
          {
            id: 4,
            description:
              'Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus',
          },
          {
            id: 5,
            description: 'Detector de humo',
          },
          {
            id: 6,
            description: 'Depósito de seguridad',
          },
        ],
      },
      {
        id: 3,
        title: 'Política de cancelación',
        subPolicies: [
          {
            id: 7,
            description:
              'Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.',
          },
        ],
      },
    ],
    images: [
      {
        id: 6,
        title: 'Chalten Suites Hostel 1',
        url: 'https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/107494839.jpg?k=00c7582dbb6ff7c9c21367043cd5929022abbb48d36f7dd693c9159e0fe244f3&o=&hp=1',
      },
      {
        id: 7,
        title: 'Chalten Suites Hostel 2',
        url: 'https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/259289089.jpg?k=66211940d4a8c90348e5b569a4815d83caaa17b78381db140604f71bee65eb06&o=&hp=1',
      },
      {
        id: 8,
        title: 'Chalten Suites Hostel 3',
        url: 'https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/43136331.jpg?k=e5264cb958491ef42fbbcf3bf7a1f6a29332ad17146ff41d625592fff40b1a25&o=&hp=1',
      },
      {
        id: 9,
        title: 'Chalten Suites Hostel 4',
        url: 'https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/259289102.jpg?k=8f748269397a1b2bb04e9460fc22566e1b9afb9bdce41d07b6c3fdfe63b9fa73&o=&hp=1',
      },
      {
        id: 10,
        title: 'Chalten Suites Hostel 5',
        url: 'https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/43136270.jpg?k=f2c93717f2980644620aa1b04c6f2ba4984e3f79b4df2eedf7a93fbc5d693a47&o=&hp=1',
      },
      {
        id: 11,
        title: 'Chalten Suites Hostel 6',
        url: 'https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/303515810.jpg?k=c346561d54084cd36730668283307b17b13f3f28d6b1f5de8a31a4fde0bd26a6&o=&hp=1',
      },
    ],
  },
  {
    id: 3,
    name: 'El Cerquero, Casa de Huéspedes',
    distance_to_nearest_tourist_site: 'A 3 km del centro',
    ranking: 3.0,
    score: 8.9,
    description_title: '¡Ideal para estadías de 4 noches!',
    description:
      'El Cerquero se encuentra en San Salvador de Jujuy y ofrece alojamiento con conexión wifi gratis y jardín con pileta al aire libre y vistas al jardín.\n\nLos alojamientos disponen de patio, aire acondicionado, TV de pantalla plana y baño privado con bidet y artículos de aseo gratuitos.\n\nTodos los días se sirve un desayuno continental en el aparthotel.\n\nPurmamarca se encuentra a 50 km de El Cerquero, mientras que Termas de Reyes está a 17 km. El aeropuerto más cercano es el aeropuerto Gobernador Horacio Guzmán, ubicado a 34 km. El alojamiento ofrece servicio de link con el aeropuerto por un adicional.\n\nA las parejas les gusta la ubicación. Le pusieron un puntaje de 8,5 para un viaje de a dos.',
    coordinates: [-24.164624, -65.3236347],
    category: {
      id: 3,
      name: 'Departamentos',
      description: '807.105 hoteles',
      image_url:
        'https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1980&q=80',
    },
    location: {
      id: 21,
      province_name: 'Provincia de Jujuy',
      city_name: 'San Salvador de Jujuy',
      country_name: 'Argentina',
    },
    features: [
      {
        id: 7,
        name: 'Pileta',
        icon: 'fa-solid fa-person-swimming',
      },
      {
        id: 4,
        name: 'Wifi',
        icon: 'fa-solid fa-wifi',
      },
      {
        id: 6,
        name: 'Apto mascotas',
        icon: 'fa-solid fa-paw',
      },
    ],
    policies: [
      {
        id: 1,
        title: 'Normas de la casa',
        subPolicies: [
          {
            id: 1,
            description: 'Check-out: 10:00',
          },
          {
            id: 2,
            description: 'No se permiten fiestas',
          },
          {
            id: 3,
            description: 'No fumar',
          },
        ],
      },
      {
        id: 2,
        title: 'Salud y seguridad',
        subPolicies: [
          {
            id: 4,
            description:
              'Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus',
          },
          {
            id: 5,
            description: 'Detector de humo',
          },
          {
            id: 6,
            description: 'Depósito de seguridad',
          },
        ],
      },
      {
        id: 3,
        title: 'Política de cancelación',
        subPolicies: [
          {
            id: 7,
            description:
              'Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.',
          },
        ],
      },
    ],
    images: [
      {
        id: 12,
        title: 'El Cerquero, Casa de Huéspedes 1',
        url: 'https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/298707961.jpg?k=2cd771db9a09ed409f284f94b4e1fe0fab003faae01a6aee4343a71885a2f6ed&o=&hp=1',
      },
      {
        id: 13,
        title: 'El Cerquero, Casa de Huéspedes 2',
        url: 'https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/298707909.jpg?k=c9a002636dbe9d6067ca76aef09c3e3f234fca375d360a03827c21f1d57b7e9c&o=&hp=1',
      },
      {
        id: 14,
        title: 'El Cerquero, Casa de Huéspedes 3',
        url: 'https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/298707952.jpg?k=406cd760f7b4e73c6413ed3cbef6393d57fbeb006600fd4b4d53c170dd20d33d&o=&hp=1',
      },
      {
        id: 15,
        title: 'El Cerquero, Casa de Huéspedes 4',
        url: 'https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/298707990.jpg?k=e0637dc1963fad06889858f9d3b76e2a34f03a766284ddf2cf85924994172922&o=&hp=1',
      },
      {
        id: 16,
        title: 'El Cerquero, Casa de Huéspedes 5',
        url: 'https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/298707986.jpg?k=4c4434f564b1a0ad96753f7329fe7426969c92a0256f2ec4a5ee4418ee28fb5a&o=&hp=1',
      },
      {
        id: 17,
        title: 'El Cerquero, Casa de Huéspedes 6',
        url: 'https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/298707992.jpg?k=7c45fadbde078afa9fc4802aef9dcf79963cd87352fa3137c4639c9eb5acf140&o=&hp=1',
      },
    ],
  },
];
