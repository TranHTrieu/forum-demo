import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-post-add-form',
  templateUrl: './post-add-form.component.html',
  styleUrls: ['./post-add-form.component.scss']
})
export class PostAddFormComponent implements OnInit {
  display = false;
  postForm: any;

  constructor() { }

  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.postForm = new FormGroup({
      'title': new FormControl(),
      'content': new FormControl(),
    });
  }

  onSubmit() {

  }

  showDialog(): void {
    this.display = true;
  }

}
