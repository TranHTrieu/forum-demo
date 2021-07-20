import {Component, OnDestroy, OnInit} from '@angular/core';
import {PostApiService} from "../../@service/_api/post-api.service";
import {Post} from "../../@model/post.model";
import {PostStoreService} from "../../@service/_store/post-store.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-new-page',
  templateUrl: './new-page.component.html',
  styleUrls: ['./new-page.component.scss']
})
export class NewPageComponent implements OnInit {
  newPosts: Post[] = [];
  postSub: Subscription | undefined;

  constructor(private postApiService: PostApiService,
              private postStoreService: PostStoreService) {}

  ngOnInit(): void {
    this.listPosts();
    this.postSub = this.postStoreService.updateStatusChanged.subscribe((status: boolean) => {
      if (status) {
        this.listPosts();
      }
    });
  }

  listPosts(): void {
    this.postApiService.getPosts().subscribe((data) => {
      this.newPosts = data;
    });
  }
}
