import { Component } from '@angular/core';
import { AdminRoutingModule } from "../../../admin/admin-routing.module";
import { HeaderComponent } from "../../components/header/header.component";
import { FooterComponent } from "../../components/footer/footer.component";

@Component({
  selector: 'app-layout-page',
  imports: [AdminRoutingModule, HeaderComponent, FooterComponent],
  templateUrl: './layout-page.component.html',
  styleUrl: './layout-page.component.css'
})
export class LayoutPageComponent {

}
