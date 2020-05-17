import { Injectable } from '@angular/core';
import {map} from 'rxjs/operators';
import {HttpClient, HttpHeaders, HttpClientModule} from '@angular/common/http';
const httpOptions = {
  headers: new HttpHeaders({
    'Access-Control-Allow-Origin': 'http://192.168.8.142:8080/pool',
  })
};

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  url = 'http://192.168.8.142:8080/pool';

  constructor(
    private http: HttpClient
  ) {

  }

  getMessage() {
    return this.http.get(this.url, httpOptions)
      .pipe(map(data => {
        const result = [];
        for (const key in data) {
          if (data.hasOwnProperty(key)) {
            result.push({...data[key], id: key });
          }
        }

        return result;
      }));
  }
}
