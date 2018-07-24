import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import{HttpModule} from '@angular/http';
import { AppComponent } from './app.component';
import { ListpatientComponent } from './components/listpatient/listpatient.component';
import { AddPatientComponent } from './components/add-patient/add-patient.component';
import { createUrlResolverWithoutPackagePrefix } from '../../node_modules/@angular/compiler';
import{PatientService} from './service/patient.service';
import './styles/css/bootstrap.min.css';
import { ListExaminationComponent } from './components/list-examination/list-examination.component';
import { ListQuestionsComponent } from './components/list-questions/list-questions.component';
import { ExaminationService } from './service/examination.service';
import { QuestionService } from './service/question.service';
import { AddExaminationComponent } from './components/add-examination/add-examination.component';
import { HttpClientModule } from '@angular/common/http';
import {MatButtonModule, MatCheckboxModule, MatFormFieldModule, MatTableModule, MatDialogModule } from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MyDialogComponent } from './components/my-dialog/my-dialog.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


 const appRoutes:Routes=[
   {path:'', component:ListpatientComponent},
   {path:'addPatient', component:AddPatientComponent},
   {path:'examinationList', component:ListExaminationComponent},
   {path:'examinationList/upsert/:id', component:AddExaminationComponent},
   {path:'examinationList/upsert', component:AddExaminationComponent},
 ];

@NgModule({
  declarations: [
    AppComponent,
    ListpatientComponent,
    AddPatientComponent,
    ListExaminationComponent,
    ListQuestionsComponent,
    AddExaminationComponent,
    MyDialogComponent
      ],
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    MatDialogModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatFormFieldModule
  ],

  
    entryComponents:[
     MyDialogComponent
    ],

  providers: [PatientService,ExaminationService, QuestionService],
  bootstrap: [AppComponent],
})
export class AppModule { }
