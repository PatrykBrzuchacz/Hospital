import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';


// Material inports ---------
import {MatInputModule} from '@angular/material/input';
import {MatMenuModule} from '@angular/material/menu';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatDialogModule} from '@angular/material/dialog';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatTabsModule} from '@angular/material/tabs';
import {MatSelectModule} from '@angular/material/select';
import {MatCheckboxModule} from '@angular/material/checkbox';




//-----------
import { NavbarComponent } from './components/navbar/navbar/navbar.component';
import { HomepageComponent } from './components/content/homepage/homepage.component';
import { DashboardComponent } from './components/content/dashboard/dashboard.component';
import { MatTableModule, MatPaginatorModule, MatSortModule } from '@angular/material';
import { RegistrationDialogComponent } from './components/content/registration-dialog/registration-dialog.component';
import { UserService } from './service/userService';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { PatientService } from './service/patient.service';
import { PatientsListComponent } from './components/content/patients-list/patients-list.component';
import { UpdatePatientDialogComponent } from './components/content/update-patient-dialog/update-patient-dialog.component';
import { LayoutModule } from '@angular/cdk/layout';
import { NewPatientDialogComponent } from './components/content/new-patient-dialog/new-patient-dialog.component';
import { ExaminationsListComponent } from './components/content/examinations-list/examinations-list.component';
import { ExaminationService } from './service/examination.service';
import { NewExaminationDialogComponent } from './components/content/new-examination-dialog/new-examination-dialog.component';
import { QuestionService } from './service/question.service';
import { LoginPageComponent } from './components/content/login-page/login-page.component';
import { FooterComponent } from './components/footer/footer/footer.component';
import { PatientRegistrationComponent } from './components/content/patient-registration/patient-registration.component';
import { DoctorRegistrationComponent } from './components/content/doctor-registration/doctor-registration.component';
import { MainPageComponent } from './components/content/main-page/main-page.component';
import { SidenavComponent } from './components/sidebar/sidenav/sidenav.component';
import { PatientMainPageComponent } from './components/content/patient-main-page/patient-main-page.component';

const appRoutes: Routes = [
  {path: '', component: LoginPageComponent},
  {path: 'home', component: HomepageComponent},
  {path: 'patient-registration', component: PatientRegistrationComponent},
  {path: 'doctor-registration', component: DoctorRegistrationComponent},
  {path: 'patient-main-page', component: PatientMainPageComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomepageComponent,
    DashboardComponent,
    RegistrationDialogComponent,
    PatientsListComponent,
    UpdatePatientDialogComponent,
    NewPatientDialogComponent,
    ExaminationsListComponent,
    NewExaminationDialogComponent,
    LoginPageComponent,
    FooterComponent,
    PatientRegistrationComponent,
    DoctorRegistrationComponent,
    MainPageComponent,
    SidenavComponent,
    PatientMainPageComponent
    
    
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatInputModule,
    RouterModule.forRoot(appRoutes),
    MatMenuModule,
    MatToolbarModule,
    MatButtonModule,
    MatGridListModule,
    MatIconModule,
    MatCardModule,
    MatSidenavModule,
    MatListModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatDialogModule,
    FormsModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatTabsModule,
    LayoutModule,
    MatSelectModule,
    MatCheckboxModule
  ],
  entryComponents: [
    RegistrationDialogComponent,
    UpdatePatientDialogComponent,
    NewPatientDialogComponent,
    NewExaminationDialogComponent,
  ],

  providers: [
    UserService,
    PatientService,
    ExaminationService,
    QuestionService,
    HttpClient
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
