import {WeatherCode} from './weather-code';

export interface City {
  name: string;
  country: string;
  temperature: bigint;
  weatherCode: WeatherCode;
}
