import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Post} from "../../@model/post.model";
import {PostApiService} from "../../@service/_api/post-api.service";
import {PostStoreService} from "../../@service/_store/post-store.service";

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.scss']
})
export class PostFormComponent implements OnInit {
  display = false;
  postForm: any;

  constructor(private postApiService: PostApiService,
              private postStoreService: PostStoreService) { }

  ngOnInit(): void {
    this.initForm();
  }

  initForm(): void {
    this.postForm = new FormGroup({
      'title': new FormControl(''),
      'content': new FormControl(''),
    });
  }

  onSubmit(): void {
    console.log('button clicked');
    const post: Post = new Post(
      this.postForm.get('title').value,
      this.postForm.get('content').value,
      [],
    );
    this.postApiService.addPost(post).subscribe((res) => {
      this.postStoreService.setUpdateStatus();
      this.display = false;
    });
    this.postForm.reset();
  }

  showDialog(): void {
    this.display = true;
  }

}
