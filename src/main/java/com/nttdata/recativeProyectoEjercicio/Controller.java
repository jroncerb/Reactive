package com.nttdata.recativeProyectoEjercicio;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class Controller {

	@GetMapping(path="/numbers", produces = "text/event-stream")
	public Flux<Integer>numbers(){
		
		//metodo para crear numero del uno a l 20 con duracion de 1 "
		Flux<Integer> flux = Flux.range(1, 30).delayElements(Duration.ofSeconds(1));
		
		return flux;
	}
	
	
	//url para buscar en internet
	@GetMapping(path = "/numbers-with-subscribers", produces = "text/event-stream")

	public Flux<Integer> numbersWithSubscribers() {

	Flux<Integer> flux = Flux.range(1, 30).delayElements(Duration.ofSeconds(1));



	flux.subscribe(n -> Subscriber.print(n)); // Suscriptor 1

	flux.subscribe(n -> System.out.println("Subscriber 2: " + n)); // Suscriptor 2



	return flux; // Suscriptor 3

	}
	
	
}
