export interface Instalacion {
    id: string;
    nombre: string;
    descripcion: string;
    idAdministrador: string 
    idsUsuariosPermitidos: [string]; 
  }
  