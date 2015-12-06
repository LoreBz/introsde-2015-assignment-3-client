package client;

import introsde.assignment.soap.HealthMeasureHistory;
import introsde.assignment.soap.LifeStatus;
import introsde.assignment.soap.MeasureDefinition;
import introsde.assignment.soap.People;
import introsde.assignment.soap.PeopleService;
import introsde.assignment.soap.Person;

import java.io.FileNotFoundException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

public class PeopleClient {
	static int first_person_id = 1;
	static int mid = 1;

	public static void main(String[] args) throws FileNotFoundException,
			JAXBException {
		//
		JAXBContext jc = JAXBContext.newInstance("introsde.assignment.soap");
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// get proxy
		PeopleService pService = new PeopleService();
		People people = pService.getPeopleImplPort();

		// start calling methods
		// Method #1: readPersonList() => List
		System.out.println("Method #1: readPersonList() => List");
		List<Person> personList = people.readPersonList();
		if (!personList.isEmpty()) {
			first_person_id = personList.get(0).getIdPerson();
			for (Person p : personList) {
				try {
					JAXBElement<Person> pn = new JAXBElement<Person>(new QName(
							"http://soap.assignment.introsde/", "person"),
							Person.class, p);
					m.marshal(pn, System.out);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("errore");
				}
			}
		}

		// Method #2: readPerson(Long id) => Person
		System.out.println("\n\nMethod #2: readPerson(Long id) => Person");
		Person person1 = people.readPerson(new Long(first_person_id));
		JAXBElement<Person> p1 = new JAXBElement<Person>(new QName(
				"http://soap.assignment.introsde/", "person"), Person.class,
				person1);
		m.marshal(p1, System.out);
		// out.println(person1.toString());

		// Method #3: updatePerson(Person p) => Person
		System.out.println("\n\nMethod #3: updatePerson(Person p) => Person");
		int rnd = new Random(System.currentTimeMillis()).nextInt();
		person1.setName("newName" + rnd);
		Person upp=people.updatePerson(person1);
		JAXBElement<Person> pu = new JAXBElement<Person>(new QName(
				"http://soap.assignment.introsde/", "person"), Person.class,
				upp);
		m.marshal(pu, System.out);

		// Method #4: createPerson(Person p) => Person
		System.out.println("\n\nMethod #4: createPerson(Person p) => Person");
		Person newPerson = new Person();
		int rndnew = new Random(System.currentTimeMillis()).nextInt();
		newPerson.setName("CreatedName" + rndnew);
		newPerson.setLastname("CreatedLastname" + rndnew);
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		DatatypeFactory datatypeFactory = null;
		try {
			datatypeFactory = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		XMLGregorianCalendar now = datatypeFactory
				.newXMLGregorianCalendar(gregorianCalendar);
		newPerson.setBirthdate(now);
		Person pcr = people.createPerson(newPerson);
		JAXBElement<Person> pc = new JAXBElement<Person>(new QName(
				"http://soap.assignment.introsde/", "person"), Person.class,
				pcr);
		m.marshal(pc, System.out);

		// Method #5: deletePerson(Long id)
		System.out.println("\n\nMethod #5: deletePerson(Long id)");
		int idToDelete = pcr.getIdPerson();
		boolean del = people.deletePerson(new Long(idToDelete));
		System.out.println("Person with ID=" + idToDelete + " deleted? Ans: "
				+ del);

		// Method #6: readPersonHistory(Long id, String measureType) => List
		System.out
				.println("\n\nMethod #6: readPersonHistory(Long id, String measureType) => List");
		List<HealthMeasureHistory> hmlist = people.readPersonHistory(new Long(
				first_person_id), "weight");

		if (!hmlist.isEmpty()) {
			mid = hmlist.get(0).getIdMeasureHistory();
			for (HealthMeasureHistory hm : hmlist) {
				try {
					JAXBElement<HealthMeasureHistory> a = new JAXBElement<HealthMeasureHistory>(
							new QName("http://soap.assignment.introsde/",
									"healthMeasure"),
							HealthMeasureHistory.class, hm);
					m.marshal(a, System.out);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("errore");
				}
			}
		}

		// Method #7: readMeasureTypes() => List
		System.out.println("\n\nMethod #7: readMeasureTypes() => List");
		List<MeasureDefinition> mdlist = people.readMeasureTypes();
		for (MeasureDefinition md : mdlist) {
			try {
				JAXBElement<MeasureDefinition> a = new JAXBElement<MeasureDefinition>(
						new QName("http://soap.assignment.introsde/",
								"measureDefinition"), MeasureDefinition.class,
						md);
				m.marshal(a, System.out);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("errore");
			}
		}

		// Method #8: readPersonMeasure(Long id, String measureType, Long mid)
		// => Measure
		System.out
				.println("\n\nMethod #8: readPersonMeasure(Long id, String measureType, Long mid) => Measure");
		HealthMeasureHistory record = people.readPersonMeasure(new Long(
				first_person_id), "weight", new Long(mid));
		JAXBElement<HealthMeasureHistory> a = new JAXBElement<HealthMeasureHistory>(
				new QName("http://soap.assignment.introsde/",
						"HealthMeasureHistory"), HealthMeasureHistory.class,
				record);
		m.marshal(a, System.out);

		// Method #9: savePersonMeasure(Long id, Measure m) =>
		System.out
				.println("\n\nMethod #9: savePersonMeasure(Long id, Measure m) =>");
		LifeStatus newLifestatus = new LifeStatus();
		MeasureDefinition md = new MeasureDefinition();
		md.setIdMeasureDef(1);
		md.setMeasureName("weight");
		md.setMeasureType("double");
		newLifestatus.setMeasureDefinition(md);
		newLifestatus.setValue("85.0");
		LifeStatus savedMeasure = people.savePersonMeasure(new Long(1),
				newLifestatus);
		JAXBElement<LifeStatus> svm = new JAXBElement<LifeStatus>(new QName(
				"http://soap.assignment.introsde/", "LifeStatus"),
				LifeStatus.class, savedMeasure);
		m.marshal(svm, System.out);

		// Method #10: updatePersonMeasure(Long id, Measure m) => Measure
		System.out
				.println("\n\nMethod #10: updatePersonMeasure(Long id, Measure m) => Measure ");
		int rndvalue = new Random().nextInt(20);
		record.setValue("" + (60 + rndvalue));
		record.setTimestamp(now);
		HealthMeasureHistory updatedHM = people.updatePersonMeasure(new Long(
				first_person_id), record);
		JAXBElement<HealthMeasureHistory> upm = new JAXBElement<HealthMeasureHistory>(
				new QName("http://soap.assignment.introsde/",
						"HealthMeasureHistory"), HealthMeasureHistory.class,
				updatedHM);
		m.marshal(upm, System.out);
	}
}
