import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PostApiService} from "../../../@service/_api/post-api.service";
import {CommentStoreService} from "../../../@service/_store/comment-store.service";
import {FormControl, FormGroup} from "@angular/forms";
import {Comment} from "../../../@model/comment.model";
import {CommentApiService} from "../../../@service/_api/comment-api.service";
import {Post} from "../../../@model/post.model";

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.scss']
})
export class PostDetailComponent implements OnInit {
  post: Post = new Post();
  postId: any;
  commentForm: any;
  commentSub: any;
  display = false;

  constructor(private postApiService: PostApiService,
              private commentApiService: CommentApiService,
              private commentStoreService: CommentStoreService,
              private route: ActivatedRoute,
              private router: Router) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handlePostDetail();
    });
    this.commentSub = this.commentStoreService.updateStatusChanged.subscribe(() => {
      this.listComments();
    });
    this.initForm();
  }

  initForm(): void {
    this.commentForm = new FormGroup({
      'content': new FormControl(''),
    });
  }

  onSubmit(): void {
    console.log('Submitting comment');
    const comment: Comment = new Comment(this.commentForm.get('content').value);
    this.commentApiService.addComment(comment).subscribe((res) => {
      this.commentStoreService.setUpdateStatus();
      this.display = false;
    });
    this.commentForm.reset();
  }

  handlePostDetail(): void {
    // @ts-ignore
    this.postId = +this.route.snapshot.paramMap.get('id');
    if (!Number.isInteger(this.postId)) {
      this.router.navigate(['/not-found']);
      return;
    }
    this.postApiService.getPost(this.postId).subscribe((data) => {
      this.post = data;
    });
  }

  listComments(): void {
    this.commentApiService.getCommentsByPostId(this.postId).subscribe((data: any) => {
      this.post.comments = data;
    })
  }

  showDialog(): void {
    this.display = true;
  }
}
