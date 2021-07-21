import {RouterModule, Routes} from "@angular/router";
import {NewPageComponent} from "./@page/new-page/new-page.component";
import {NgModule} from "@angular/core";
import {PostDetailPageComponent} from "./@page/post-detail-page/post-detail-page.component";

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: NewPageComponent},
  {path: 'posts/:id', component: PostDetailPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
