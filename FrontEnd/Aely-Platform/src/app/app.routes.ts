import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: 'auth',
        loadChildren: () => import('./auth/auth-routing.module').then(m => m.AuthRoutingModule)
    },
    {
        path: 'app',
        loadChildren: () => import('./app/app-routing.module').then(m => m.AppRoutingModule)
    },
    {
        path: 'admin',
        loadChildren: () => import('./admin/admin-routing.module').then(m => m.AdminRoutingModule)
    },
    {
        path: '**',
        redirectTo: 'auth/login',
        pathMatch: 'full'
    }
];
