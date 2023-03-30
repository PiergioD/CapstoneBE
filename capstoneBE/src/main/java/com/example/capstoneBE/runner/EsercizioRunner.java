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

	@Autowired
	EsercizioService serviceEser;
	@Autowired
	SchedaService serviceScheda;
	@Autowired
	UserService serviceUser;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...Per creare esercizio e scheda");

//		popolaDbScheda();

//		popolaDbEsercizio();

//		
//		Scheda schedaPresa1= serviceScheda.getbyId(1l);
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
//		Scheda schedaPresa2= serviceScheda.getbyId(1l);
//		System.out.println(schedaPresa2);
	}

	// metodo per popolarmi il db di schede
	public void popolaDbScheda() {
		var list = Stream.of(new Scheda("AllenamentoDelMartedi", serviceUser.getbyId(2l)),
				new Scheda("AllenamentoDelGiovedi", serviceUser.getbyId(2l))
//				new Scheda("AllenamentoDelSabato", serviceUser.getbyId(3l))

		).toList();
		serviceScheda.creaAll(list);
		System.out.println("Schede Creata nel db");
	}

//	
//	
//	// metodo per popolarmi il db di esercizi
//	
	public void popolaDbEsercizio() {
		var list = Stream.of(

				// dorso scheda 1
				new Esercizio("Stacco da terra",
						"Impugnare un bilanciere a terra e, attraverso l’azione dei muscoli delle gambe, imprimere energia per sollevarlo fino a tornare in posizione eretta",
						GruppiMuscolari.Dorso, 4, 8, serviceScheda.getbyId(1l)),
				new Esercizio("Rematore con bilanciere",
						"Tenendo un bilanciere con le mani a presa inversa, con le braccia distese e il busto piegato in avanti. Poi, solleva il bilanciere verso il petto tirando, mantenendo il busto fermo",
						GruppiMuscolari.Dorso, 3, 15, serviceScheda.getbyId(1l)),
				new Esercizio("Pull-up",
						"Agganciati a una sbarra con le mani in presa ampia, e sollevati fino a portare il mento sopra la barra",
						GruppiMuscolari.Dorso, 4, 8, serviceScheda.getbyId(1l)),
				new Esercizio("Lat machine",
						"Seduto sulla macchina, afferra la barra con le mani in presa ampia e tirala verso il petto, mantenendo la schiena dritta",
						GruppiMuscolari.Dorso, 5, 8, serviceScheda.getbyId(1l)),

				// addominali in shceda 1
//				new Esercizio("Crunches","sdraiati sulla schiena con le ginocchia piegate e le mani dietro la testa. Contrai gli addominali e solleva la testa e le spalle dal pavimento, mantenendo la parte bassa della schiena a contatto con il pavimento",GruppiMuscolari.Addominali,4,25,serviceScheda.getbyId(1l)),
//				new Esercizio("Plank","posizionati a terra a faccia in giù e appoggia i gomiti e le braccia sul pavimento, mantenendo il corpo in linea retta dalle spalle ai talloni. Contrai gli addominali e mantieni la posizione per 30 secondi",GruppiMuscolari.Addominali,3,0,serviceScheda.getbyId(1l)),
//				new Esercizio("Russian twist","sdraiati sulla schiena con le ginocchia piegate e le mani intrecciate dietro la testa. Solleva la testa e le spalle dal pavimento e ruota il busto verso un lato, portando il gomito opposto verso il ginocchio opposto",GruppiMuscolari.Addominali,4,8,serviceScheda.getbyId(1l)),
//				new Esercizio("Mountain climbers","posizionati a terra a faccia in giù in posizione di push-up. Porta il ginocchio destro verso il petto e poi torna alla posizione di partenza. Ripeti con il ginocchio sinistro e continua ad alternare le gambe. ",GruppiMuscolari.Addominali,3,50,serviceScheda.getbyId(1l)),

//				// tricipiti in scheda 1 
				new Esercizio("French Press con manubri",
						"Sdraiati sulla panca con i piedi appoggiati a terra, prendi i manubri e posizionali sopra il petto, con i gomiti piegati a 90 gradi. Espandi le braccia portando i manubri verso l'alto fino ad estendere le braccia completamente",
						GruppiMuscolari.Tricipiti, 3, 12, serviceScheda.getbyId(1l)),
				new Esercizio("Push-down con la corda",
						"Posiziona la corda sulla barra di trazione e afferrala con le mani. Fai un passo avanti per stabilizzarti e spingi la corda verso il basso finché le braccia non sono completamente estese",
						GruppiMuscolari.Tricipiti, 3, 15, serviceScheda.getbyId(1l)),
				new Esercizio("Estensioni con Manubri",
						"Seduto sulla panca, con i palmi delle mani rivolti verso l'alto. Solleva i manubri e posizionali sopra la testa con le braccia estese. Piega i gomiti lentamente e abbassa i manubri dietro la testa",
						GruppiMuscolari.Tricipiti, 4, 8, serviceScheda.getbyId(1l)),
				new Esercizio("Dips",
						"Posizionati tra due panche parallele, appoggia le mani sul bordo della panca dietro di te e allunga le gambe davanti a te. Abbassa il corpo lentamente piegando i gomiti fino a quando i tricipiti sono completamente estesi",
						GruppiMuscolari.Tricipiti, 3, 10, serviceScheda.getbyId(1l)),
//				

//				//petto scheda 2
				new Esercizio("Panca piana con bilanciere",
						"Sdraiati sulla panca. Afferra la barra con le mani leggermente più larghe delle spalle, abbassa la barra fino al petto e solleva di nuovo la barra",
						GruppiMuscolari.Petto, 4, 8, serviceScheda.getbyId(2l)),
				new Esercizio("Croci con Manubri",
						"Sdraiati sulla panca. Solleva i manubri sopra il petto, con le braccia completamente estese, e poi abbassali lentamente fino a quando senti la tensione nel petto",
						GruppiMuscolari.Petto, 3, 12, serviceScheda.getbyId(2l)),
				new Esercizio("Panca inclinata con manubri",
						"Sdraiati sulla panca inclinata. Solleva i manubri fino a quando le braccia sono completamente estese, poi abbassali lentamente fino a toccare il petto",
						GruppiMuscolari.Petto, 4, 8, serviceScheda.getbyId(2l)),
				new Esercizio("Flessioni su parallele",
						"Posizionati tra due parallele e solleva i piedi in modo che il tuo peso sia sostenuto dalle braccia. Abbassati fino a quando il petto non tocca le parallele",
						GruppiMuscolari.Petto, 3, 10, serviceScheda.getbyId(2l)),

//				// bicipiti in scheda 2
				new Esercizio("Curl con manubri",
						"In piedi, prendi un manubrio in ogni mano e tienili ai lati del corpo con i palmi rivolti verso l'esterno. Solleva i manubri verso le spalle, piegando i gomiti",
						GruppiMuscolari.Bicipiti, 4, 10, serviceScheda.getbyId(2l)),
				new Esercizio("Curl con bilanciere",
						"In piedi, afferra un bilanciere con le mani a larghezza spalle e tienilo a braccia tese. Solleva il bilanciere verso le spalle, piegando i gomiti",
						GruppiMuscolari.Bicipiti, 6, 8, serviceScheda.getbyId(2l)),
				new Esercizio("Hammer Curl",
						"In piedi, prendi un manubrio in ogni mano e tienili ai lati del corpo. Solleva i manubri verso le spalle",
						GruppiMuscolari.Bicipiti, 4, 8, serviceScheda.getbyId(2l)),
				new Esercizio("Chin-up",
						"Afferrati alla sbarra con le mani a larghezza spalle. Sollevati fino a portare il mento sopra la sbarra, mantenendo i gomiti vicini al corpo",
						GruppiMuscolari.Bicipiti, 3, 10, serviceScheda.getbyId(2l))

//				// gambe scheda 3
//				new Esercizio("Squat",
//						"Posiziona i piedi alla larghezza spalle,piega le ginocchia finché le cosce non sono parallele al pavimento. Poi spingiti verso l'alto utilizzando i quadricipiti",
//						GruppiMuscolari.Gambe, 4, 8, serviceScheda.getbyId(3l)),
//				new Esercizio("Affondi",
//						"In piedi, posiziona piede avanti e uno dietro, con i piedi larghezza spalle. Fletti finché il ginocchio posteriore tocca pavimento,spingiti verso l'alto coi quadricipiti",
//						GruppiMuscolari.Gambe, 3, 12, serviceScheda.getbyId(3l)),
//				new Esercizio("Leg Extension",
//						"Seduto su una panca con i piedi appoggiati su un supporto, estendi le gambe spingendo verso l'alto il supporto con i piedi, coi quadricipiti. Poi rilascia lentamente il supporto",
//						GruppiMuscolari.Gambe, 4, 8, serviceScheda.getbyId(3l)),
//				new Esercizio("Step-up",
//						"Posiziona un piede su gradino o panca, poi spingi verso l'alto utilizzando il piede sulla panca per salire. Poi scendi",
//						GruppiMuscolari.Gambe, 3, 10, serviceScheda.getbyId(3l)),
//
//				// spalle scheda 3
//				new Esercizio("Military press con bilanciere",
//						"Stando in piedi, piedi larghezza delle spalle e il bilanciere in posizione di partenza (vicino alle clavicole), spingi il bilanciere sopra la testa. ",
//						GruppiMuscolari.Spalle, 4, 8, serviceScheda.getbyId(3l)),
//				new Esercizio("Alzate laterali",
//						"In piedi, con le braccia lungo i fianchi, solleva le braccia verso i lati,gomiti leggermente flessi, fino a quando le mani sono all'altezza delle spalle",
//						GruppiMuscolari.Spalle, 3, 12, serviceScheda.getbyId(3l)),
//				new Esercizio("Shoulder shrugs",
//						"In piedi, con le braccia lungo i fianchi, solleva le spalle verso le orecchie, mantenendo i braccioli dritti",
//						GruppiMuscolari.Spalle, 4, 8, serviceScheda.getbyId(3l)),
//				new Esercizio("Reverse fly",
//						"In piedi,piedi larghezza spalle, inclinati in avanti e tieni i manubri in mano. Solleva le braccia verso i lati, gomiti legg. flessi, fino a altezza spalle",
//						GruppiMuscolari.Spalle, 3, 10, serviceScheda.getbyId(3l))

		).toList();
		serviceEser.creaAll(list);
		System.out.println("Esercizi creati nel db");
	}

}
