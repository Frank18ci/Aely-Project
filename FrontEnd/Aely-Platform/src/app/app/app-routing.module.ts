import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutPageComponent } from './pages/layout-page/layout-page.component';
import { BusquedaComponent } from './pages/busqueda/busqueda.component';
import { BuscarComponent } from './pages/buscar/buscar.component';
import { MisReservasComponent } from './pages/mis-reservas/mis-reservas.component';

const routes: Routes = [
  {
    path: '',
    component: LayoutPageComponent,
    children: [
      {
        path: 'busqueda',
        component: BusquedaComponent
      },
      {
        path: 'buscar',
        component: BuscarComponent
      },
      {
        path: 'mis-reservas',
        component: MisReservasComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
