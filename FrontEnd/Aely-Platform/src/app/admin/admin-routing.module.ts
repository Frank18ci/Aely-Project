import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutPageComponent } from './pages/layout-page/layout-page.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AeropuertoPageComponent } from './pages/aeropuerto-page/aeropuerto-page.component';

const routes: Routes = [
  {
    path: '',
    component: LayoutPageComponent,
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent
      },
      {
        path: 'aeropuertos',
        component: AeropuertoPageComponent
      },
      {
        path: '**',
        redirectTo: 'aeropuertos',
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
