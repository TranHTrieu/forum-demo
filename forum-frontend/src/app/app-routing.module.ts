import {RouterModule, Routes} from "@angular/router";
import {NewPageComponent} from "./@page/new-page/new-page.component";
import {NgModule} from "@angular/core";

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: NewPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
