import { Component } from '@angular/core';
import { PdfGeneratorService } from '../app/service/pdf-generator/pdf-generator.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})


export class AppComponent {
  title = 'job';
  constructor(private pdfGenerator: PdfGeneratorService) { }

  generatePdf(): void {
    this.pdfGenerator.generatePdf();
  }
}
