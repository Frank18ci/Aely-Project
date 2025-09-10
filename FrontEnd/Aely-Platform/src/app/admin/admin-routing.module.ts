import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutPageComponent } from './pages/layout-page/layout-page.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AeropuertoPageComponent } from './pages/aeropuerto-page/aeropuerto-page.component';
import { VuelosPageComponent } from './pages/vuelos-page/vuelos-page.component';
import { ReservasPageComponent } from './pages/reservas-page/reservas-page.component';
import { UsuariosPageComponent } from './pages/usuarios-page/usuarios-page.component';
import { ReportesPageComponent } from './pages/reportes-page/reportes-page.component';

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
        path: 'vuelos',
        component: VuelosPageComponent
      },
      {
        path: 'reservas',
        component: ReservasPageComponent
      },
      {
        path: 'usuarios',
        component: UsuariosPageComponent
      },
      {
        path: 'reportes',
        component: ReportesPageComponent
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
