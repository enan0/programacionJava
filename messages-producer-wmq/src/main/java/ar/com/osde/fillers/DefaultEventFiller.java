package ar.com.osde.fillers;

import ar.com.osde.middleware.es.model.Event;
import ar.com.osde.middleware.es.model.LevelEnum;

public class DefaultEventFiller implements EventFiller {

	private String defaultSource;
	
	private String defaultNamespace;
	
	private String defaultEventName;
	
	private String dafaultLevel;
	
	private Event event;
	
	private static final String PREFIJO_API = "MP_WMQ.";
	
	public DefaultEventFiller(String namespace, String eventName, String source) {
		Event event = new Event();
		if(namespace == null) {
			namespace = "";
		}
		event.setNameSpace(namespace);
		if(eventName == null) {
			eventName = "";
		}
		event.setEventName(PREFIJO_API + eventName);
		if(source == null) {
			source = "";
		}
		event.setSource(source);
		event.setTimestamp(String.valueOf(System.currentTimeMillis()));
		this.event = event;
	}
	
	public void fillEvent(Event event) {
		event.setSource(getDefaultSource());
		event.setEventName(getDefaultEventName());
		event.setNameSpace(getDefaultNamespace());
		event.setLevel(LevelEnum.valueOf(getDafaultLevel()));
		event.setTimestamp(String.valueOf(System.currentTimeMillis()));
	}

	public String getDefaultSource() {
		return this.defaultSource;
	}

	public void setDefaultSource(String defaultSource) {
		this.defaultSource = defaultSource;
	}

	public String getDefaultNamespace() {
		return this.defaultNamespace;
	}

	public void setDefaultNamespace(String defaultNamespace) {
		this.defaultNamespace = defaultNamespace;
	}

	public String getDefaultEventName() {
		return this.defaultEventName;
	}

	public void setDefaultEventName(String defaultEventName) {
		this.defaultEventName = defaultEventName;
	}

	public String getDafaultLevel() {
		return this.dafaultLevel;
	}

	public void setDafaultLevel(String dafaultLevel) {
		this.dafaultLevel = dafaultLevel;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}