import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material';
import { FormGroup, FormBuilder } from '@angular/forms';
@Component({
  templateUrl: './my-dialog.component.html',

})
export class MyDialogComponent {
  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private MyDialog: MatDialogRef<MyDialogComponent>
  ) {}

  ngOnInit() {
    this.form = this.formBuilder.group({
      question: ''
    })
  }

  submit(form) {
    this.MyDialog.close(`${form.value.question}`);
  }
}


