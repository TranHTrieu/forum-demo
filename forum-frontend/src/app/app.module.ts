import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {CardModule} from "primeng/card";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PostComponent } from './@shared/post/post.component';
import { NewPageComponent } from './@page/new-page/new-page.component';
import {AppRoutingModule} from "./app-routing.module";
import {NavbarComponent} from "./@shared/navbar/navbar.component";
import {ButtonModule} from "primeng/button";
import {InputTextModule} from "primeng/inputtext";
import {PostFormComponent} from "./@shared/post-form/post-form.component";
import {DialogModule} from "primeng/dialog";
import {InputTextareaModule} from "primeng/inputtextarea";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { PostDetailPageComponent } from './@page/post-detail-page/post-detail-page.component';
import { PostDetailComponent } from './@page/post-detail-page/post-detail/post-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PostComponent,
    NewPageComponent,
    PostFormComponent,
    PostDetailPageComponent,
    PostDetailComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ButtonModule,
    InputTextModule,
    InputTextareaModule,
    CardModule,
    DialogModule,
    NgbModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
