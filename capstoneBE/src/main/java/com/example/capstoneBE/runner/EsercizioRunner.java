package com.example.capstoneBE.runner;

import java.util.HashSet;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.capstoneBE.entity.Esercizio;
import com.example.capstoneBE.entity.GruppiMuscolari;
import com.example.capstoneBE.entity.Scheda;
import com.example.capstoneBE.service.EsercizioService;
import com.example.capstoneBE.service.SchedaService;
import com.example.capstoneBE.service.UserService;


@Component
public class EsercizioRunner implements ApplicationRunner {

	@Autowired EsercizioService serviceEser;
	@Autowired SchedaService serviceScheda;
	@Autowired UserService serviceUser;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
			
//		popolaDbScheda();
		
//		popolaDbEsercizio();
		
//		
		Scheda schedaPresa1= serviceScheda.getbyId(1l);
//		System.out.println(schedaPresa1);
		
		
//		Esercizio esPreso1=new Esercizio("Crunches","sdraiati sulla schiena con le ginocchia piegate e le mani dietro la testa. Contrai gli addominali e solleva la testa e le spalle dal pavimento, mantenendo la parte bassa della schiena a contatto con il pavimento",GruppiMuscolari.Addominali,4,25);
//		Esercizio esPreso2=new Esercizio("Plank","posizionati a terra a faccia in giù e appoggia i gomiti e le braccia sul pavimento, mantenendo il corpo in linea retta dalle spalle ai talloni. Contrai gli addominali e mantieni la posizione per 30 secondi",GruppiMuscolari.Addominali,3,0);
//		Esercizio esPreso3=new Esercizio("Russian twist","sdraiati sulla schiena con le ginocchia piegate e le mani intrecciate dietro la testa. Solleva la testa e le spalle dal pavimento e ruota il busto verso un lato, portando il gomito opposto verso il ginocchio opposto",GruppiMuscolari.Addominali,4,8);
//		Esercizio esPreso4=new Esercizio("Mountain climbers","posizionati a terra a faccia in giù in posizione di push-up. Porta il ginocchio destro verso il petto e poi torna alla posizione di partenza. Ripeti con il ginocchio sinistro e continua ad alternare le gambe. ",GruppiMuscolari.Addominali,3,50);
		
		
		
//		Esercizio esPreso1=serviceEser.getbyId(1l);
//		Esercizio esPreso2=serviceEser.getbyId(2l);
//		Esercizio esPreso3=serviceEser.getbyId(3l);
//		Esercizio esPreso4=serviceEser.getbyId(4l);
//		schedaPresa1.getEsercizi().add(esPreso1);
//		schedaPresa1.getEsercizi().add(esPreso2);
//		schedaPresa1.getEsercizi().add(esPreso3);
//		schedaPresa1.getEsercizi().add(esPreso4);
		
		
//		serviceScheda.createScheda(schedaPresa1);
		Scheda schedaPresa2= serviceScheda.getbyId(1l);
		System.out.println(schedaPresa2);
	}
	
	
	// metodo per popolarmi il db di schede
	public void popolaDbScheda() {
		var list = Stream.of(
				new Scheda("AllenamentoDelMartedi",serviceUser.getbyId(1l),new HashSet<Esercizio>()),
				new Scheda("AllenamentoDelGiovedi",serviceUser.getbyId(1l),new HashSet<Esercizio>()),
				new Scheda("AllenamentoDelSabato",serviceUser.getbyId(1l),new HashSet<Esercizio>())
				
				
				).toList();
		serviceScheda.creaAll(list);
		System.out.println("Schede Creata nel db");
	}
//	
//	
//	// metodo per popolarmi il db di esercizi
//	
	public void popolaDbEsercizio() {
		var list= Stream.of(
				
				
				// addominali in shceda 2
				new Esercizio("Crunches","sdraiati sulla schiena con le ginocchia piegate e le mani dietro la testa. Contrai gli addominali e solleva la testa e le spalle dal pavimento, mantenendo la parte bassa della schiena a contatto con il pavimento",GruppiMuscolari.Addominali,4,25),
				new Esercizio("Plank","posizionati a terra a faccia in giù e appoggia i gomiti e le braccia sul pavimento, mantenendo il corpo in linea retta dalle spalle ai talloni. Contrai gli addominali e mantieni la posizione per 30 secondi",GruppiMuscolari.Addominali,3,0),
				new Esercizio("Russian twist","sdraiati sulla schiena con le ginocchia piegate e le mani intrecciate dietro la testa. Solleva la testa e le spalle dal pavimento e ruota il busto verso un lato, portando il gomito opposto verso il ginocchio opposto",GruppiMuscolari.Addominali,4,8),
				new Esercizio("Mountain climbers","posizionati a terra a faccia in giù in posizione di push-up. Porta il ginocchio destro verso il petto e poi torna alla posizione di partenza. Ripeti con il ginocchio sinistro e continua ad alternare le gambe. ",GruppiMuscolari.Addominali,3,50)
				
				
				
				
//				// tricipiti in scheda 2
//				new Esercizio("French Press con manubri","sdraiati sulla panca con i piedi appoggiati a terra, prendi i manubri e posizionali sopra il petto, con i gomiti piegati a 90 gradi. Espandi le braccia portando i manubri verso l'alto fino ad estendere le braccia completamente",GruppiMuscolari.Tricipiti,3,12,serviceScheda.getbyId(2l)),
//				new Esercizio("Push-down con la corda","posiziona la corda sulla barra di trazione e afferrala con le mani. Fai un passo avanti per stabilizzarti e spingi la corda verso il basso finché le braccia non sono completamente estese",GruppiMuscolari.Tricipiti,3,15,serviceScheda.getbyId(2l)),
//				new Esercizio("Estensioni con Manubri","seduto sulla panca, prendi i manubri e posizionali sulle ginocchia, con i palmi delle mani rivolti verso l'alto. Solleva i manubri e posizionali sopra la testa con le braccia estese. Piega i gomiti lentamente e abbassa i manubri dietro la testa",GruppiMuscolari.Tricipiti,4,8,serviceScheda.getbyId(2l)),
//				new Esercizio("Dips","posizionati tra due panche parallele, appoggia le mani sul bordo della panca dietro di te e allunga le gambe davanti a te. Abbassa il corpo lentamente piegando i gomiti fino a quando i tricipiti sono completamente estesi",GruppiMuscolari.Tricipiti,3,10,serviceScheda.getbyId(2l)),
//				
//				
//				// bicipiti in scheda 3
//				new Esercizio("Curl con manubri","in piedi, prendi un manubrio in ogni mano e tienili ai lati del corpo con i palmi rivolti verso l'esterno. Solleva i manubri verso le spalle, piegando i gomiti",GruppiMuscolari.Bicipiti,4,10,serviceScheda.getbyId(3l)),
//				new Esercizio("Curl con bilanciere","in piedi, afferra un bilanciere con le mani a larghezza spalle e tienilo a braccia tese. Solleva il bilanciere verso le spalle, piegando i gomiti",GruppiMuscolari.Bicipiti,6,8,serviceScheda.getbyId(3l)),
//				new Esercizio("Hammer Curl","in piedi, prendi un manubrio in ogni mano e tienili ai lati del corpo con i palmi rivolti verso l'interno. Solleva i manubri verso le spalle, mantenendo i palmi rivolti verso l'interno",GruppiMuscolari.Bicipiti,4,8,serviceScheda.getbyId(3l)),
//				new Esercizio("Chin-up","afferrati alla sbarra con le mani a larghezza spalle e le palmi rivolte verso di te. Sollevati fino a portare il mento sopra la sbarra, mantenendo i gomiti vicini al corpo",GruppiMuscolari.Bicipiti,3,10,serviceScheda.getbyId(3l))
				
				
				
				).toList();
		serviceEser.creaAll(list);
		System.out.println("Esercizi creati nel db");
	}
	

}
