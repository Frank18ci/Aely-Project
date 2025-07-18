import { Component } from '@angular/core';
import { LucideAngularModule, FileIcon, Facebook, Instagram, Mail } from 'lucide-angular';

@Component({
  selector: 'app-footer',
  imports: [LucideAngularModule],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css'
})
export class FooterComponent {
  readonly fileIcon = FileIcon;
  readonly facebookIcon = Facebook;
  readonly instagramIcon = Instagram;
  readonly mailIcon = Mail;
}
