package tp1.ej3;

public class Test {
	public static void main(String[] args) {
		Estudiante[] arr_estudiantes = new Estudiante[2];
		Profesor[] arr_profesores = new Profesor[3];
		
		Estudiante e1, e2;
		e1 = new Estudiante();
		e2= new Estudiante();
		e1.setNombre("Agustin");
		e1.setApellido("Surila");
		e1.setEmail("agustinsurila@gmail.com");
		e1.setDireccion("Calle 1");
		e1.setComision("Maniana");
		
		e2.setApellido("Sanchez");
		e2.setEmail("pepesanchez@gmail.com");
		e2.setNombre("Pepe");
		e2.setDireccion("Calle 2");
		e2.setComision("Tarde");
		arr_estudiantes[0] = e1;
		arr_estudiantes[1]= e2;
		
		Profesor p1, p2, p3;
		
		p1= new Profesor();
		p2= new Profesor();
		p3= new Profesor();
		
		p1.setNombre("Miguel");
		p1.setApellido("Lopez");
		p1.setCatedra("Maniana");
		p1.setEmail("m@gmail.com");
		p1.setFacultad("Informatica");
		p2.setNombre("Mariana");
		p2.setApellido("Guti");
		p2.setCatedra("Tarde");
		p2.setEmail("m@gmail.com");
		p2.setFacultad("Informatica");
		p3.setNombre("Franco");
		p3.setApellido("Mernes");
		p3.setCatedra("Maniana");
		p3.setEmail("f@gmail.com");
		p3.setFacultad("Psicologia");
		
		arr_profesores[0] = p1;
		arr_profesores[1] = p2;
		arr_profesores[2] = p3;
	}
}
