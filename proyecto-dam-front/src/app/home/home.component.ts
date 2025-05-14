import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';  // Asegúrate de importar CommonModule
import { InstalacionService } from '../services/instalacion.service';
import { Instalacion } from '../interfaces/InstalacionInterface';  // Asegúrate de importar la interfaz

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  instalaciones: Instalacion[] = [];  // Especificamos el tipo aquí
  searchQuery: string = '';

  constructor(private instalacionService: InstalacionService) {}

  ngOnInit(): void {
    this.getInstalaciones();
  }

  getInstalaciones(): void {
    this.instalacionService.getAllInstalaciones().subscribe(
      (data) => {
        this.instalaciones = data;
      },
      (error) => {
        console.error("Error al obtener instalaciones: ", error);
      }
    );
  }

  buscarInstalacion(): void {
    if (this.searchQuery.trim() === '') {
      this.getInstalaciones();
    } else {
      this.instalacionService.findByNombre(this.searchQuery).subscribe(
        (data) => {
          this.instalaciones = data;
        },
        (error) => {
          console.error("Error al buscar instalaciones: ", error);
        }
      );
    }
  }
}
