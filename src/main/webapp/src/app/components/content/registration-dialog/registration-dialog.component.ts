import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { User } from '../../../domain/User';
import { UserService } from '../../../service/userService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration-dialog',
  templateUrl: './registration-dialog.component.html',
  styleUrls: ['./registration-dialog.component.scss']
})
export class RegistrationDialogComponent implements OnInit {

  registerForm: FormGroup;
  user: User;


  constructor(private formBuilder: FormBuilder, private userService:UserService, private router: Router) { 
    this.initRegisterForm();
  }

  ngOnInit() {
        this.initUser();

  }

  initRegisterForm() {
    this.registerForm = this.formBuilder.group({
    username: ['', Validators.required],
    last_name: ['', [Validators.required]],
    password: ['', [Validators.required]]
  });
}

initUser() {
  this.user = { username: null, last_name: null, password: null };
}

registerUser() {
  this.userService.createUser(this.user).subscribe((user) => {
    console.log(user);
    this.router.navigate(['']);
  }, (error) => {
    console.log(error);
  });
}

}
