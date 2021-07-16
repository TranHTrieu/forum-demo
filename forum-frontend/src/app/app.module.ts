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
import {PostAddFormComponent} from "./@shared/post-add-form/post-add-form.component";
import {DialogModule} from "primeng/dialog";
import {InputTextareaModule} from "primeng/inputtextarea";
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PostComponent,
    NewPageComponent,
    PostAddFormComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ButtonModule,
    InputTextModule,
    InputTextareaModule,
    CardModule,
    DialogModule,
    NgbModule,
    AppRoutingModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
