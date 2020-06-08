import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpServiceService } from '../http-service.service';
import { Model } from '../model';
import { interval, Subscription } from 'rxjs';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent implements OnInit {

  constructor(private httpService: HttpServiceService, private http: HttpClient) {}
  gyroData: Array<Model>;
  isAlarm: boolean;
  noDetection: boolean;
  isSafe: boolean;
  help: boolean;
  subscription: Subscription;
  intervalId: number;
  source = interval(3000);
  currentLength: number;
  previous = 0;
  url = 'http://localhost:8080/pool';
  pauseTime: number;
  timeLeft: number;

  interval;

  ngOnInit(): void {
    this.subscription = this.source.subscribe((val) => {
      this.getData();
    });
  }

  getData() {
    this.httpService.getMessage().subscribe((data) => {
      this.gyroData = data;
      console.log(data);
      if (this.gyroData.length === 0) {
        this.isAlarm = false;
      }
      console.log(this.previous);
      if (this.gyroData.length > this.previous) {
        console.log('ALARM!');
        this.previous = this.gyroData.length;
        this.isAlarm = true;
        this.isSafe = false;
      }
    });

  }

  quitAlarm() {
    console.log('Detection stopped');
    this.isAlarm = false;
    this.noDetection = true;
    this.isSafe = false;
    this.currentLength = this.gyroData.length;
    this.subscription.unsubscribe();
  }

  startAlarm() {
    console.log('Detection started');
    this.stopInterval();
    this.isSafe = true;
    this.noDetection = false;
    this.httpService.getMessage().subscribe(data => { this.previous = data.length;
                                                      this.subscription = this.source.subscribe((val) => this.getData());
    });
  }

  pauseAlarm() {
    this.stopInterval();
    this.help = true;
    this.isAlarm = false;
    this.isSafe = false;
    this.noDetection = true;
    console.log('Paused');
    console.log(this.pauseTime);
    this.subscription.unsubscribe();
    this.timeLeft = this.pauseTime * 60;
    this.interval = setInterval(() => {
      if (this.timeLeft > 0) {
        this.timeLeft--;
      } else {
        this.startAlarm();
        this.stopInterval();
      }
    }, 1000);
  }

  pause15() {
    this.pauseTime = 1;
    this.pauseAlarm();
  }

  pause30() {
    this.pauseTime = 30;
    this.pauseAlarm();
  }

  pause45() {
    this.pauseTime = 45;
    this.pauseAlarm();
  }

  stopInterval() {
    this.help = false;
    clearInterval(this.interval);
  }


  /*pauseAlarm() {
    this.http.put(this.url + '/deactivate?duration=' + this.durationTime, this.durationTime).subscribe(
      response => {
        console.log(response);
      }
    );
  }
  */
}

