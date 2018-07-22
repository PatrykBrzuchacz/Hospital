import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import{HttpModule} from '@angular/http';
import{FormsModule}   from '@angular/forms';
import { AppComponent } from './app.component';
import { ListpatientComponent } from './components/listpatient/listpatient.component';
import { AddPatientComponent } from './components/add-patient/add-patient.component';
import { createUrlResolverWithoutPackagePrefix } from '../../node_modules/@angular/compiler';
import{PatientService} from './service/patient.service';
import './styles/css/bootstrap.min.css';
import { ListExaminationComponent } from './components/list-examination/list-examination.component';
import { ListQuestionsComponent } from './components/list-questions/list-questions.component';
import { ExaminationService } from './service/examination.service';
 const appRoutes:Routes=[
   {path:'', component:ListpatientComponent},
   {path:'addPatient', component:AddPatientComponent},
   {path:'examinationList', component:ListExaminationComponent},
   {path:'questionList', component:ListQuestionsComponent},
 ];

@NgModule({
  declarations: [
    AppComponent,
    ListpatientComponent,
    AddPatientComponent,
    ListExaminationComponent,
    ListQuestionsComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [PatientService,ExaminationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
