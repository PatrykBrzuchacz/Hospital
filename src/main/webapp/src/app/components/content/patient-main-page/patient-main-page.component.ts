import { Component } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointState, BreakpointObserver } from '@angular/cdk/layout';

@Component({
  selector: 'app-patient-main-page',
  templateUrl: './patient-main-page.component.html',
  styleUrls: ['./patient-main-page.component.scss']
})
export class PatientMainPageComponent {
  /** Based on the screen size, switch from standard to one column per row */
  

  constructor(private breakpointObserver: BreakpointObserver) {}
}
