import { Component, OnInit } from '@angular/core';
import {WeatherService} from '../../weather.service';

@Component({
  selector: 'app-city-search',
  templateUrl: './city-search.component.html',
  styleUrls: ['./city-search.component.css']
})
export class CitySearchComponent implements OnInit {

  constructor(private service: WeatherService) { }

  ngOnInit(): void {
  }

}
