import { Component, OnInit, OnDestroy } from '@angular/core';
import { CustomEventEmitter } from '../../events/custom-event.emitter';
import { Subscription } from '../../../../node_modules/rxjs';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit, OnDestroy {

  private subscription: Subscription = new Subscription();

  constructor(private evenetEmitter: CustomEventEmitter) { }

  ngOnInit() {
    this.subscription.add(this.evenetEmitter.addPatientEmitter.subscribe(patient => {
      console.log(patient) // dodany pacjent
    }))
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

}
//eventemittery,