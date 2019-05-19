package it.polito.tdp.borders.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

import it.polito.tdp.borders.db.BordersDAO;


public class Model {
	
SimpleGraph<Country, DefaultEdge> grafo;
Map<Integer, Country > stati1;
Map<Integer, Country > stati2;
BordersDAO dao;
Map<Integer, Country> vertici;
Map<Country, Integer> count;

public List<Country> getVertici() {
	return new ArrayList<Country>(vertici.values());
}

List<Border> archi;

	public Model() {
		grafo= new SimpleGraph<>(DefaultEdge.class);
		stati1= new HashMap<Integer,Country>();
		stati2= new HashMap<Integer,Country>();
		dao= new BordersDAO();
		vertici= new HashMap<Integer, Country>();
		//archi= new ArrayList<Border>();
		count= new HashMap<Country, Integer>();
		dao.loadAllCountries();
	}

	public SimpleGraph<Country, DefaultEdge> getGrafo() {
		return grafo;
	}

	public void setGrafo(SimpleGraph<Country, DefaultEdge> grafo) {
		this.grafo = grafo;
	}

	public void creaGrafo(int anno) {
		
		
		
		for(Border b: dao.getCountryPairs(anno)) {
			if(!vertici.containsKey(b.getCodS1())) {
				vertici.put(b.getCodS1(), b.getC1());
				grafo.addVertex(b.getC1());
			}
			if(!vertici.containsKey(b.getCodS2())) {
				vertici.put(b.getCodS2(), b.getC2());
				grafo.addVertex(b.getC2());
			}
				
			DefaultEdge edge = grafo.getEdge(b.getC1(), b.getC2());
			if(edge == null) {
				grafo.addEdge(b.getC1(), b.getC2());
			} 
		
		
	}
	}
	public int grado(Country c) {
			return grafo.degreeOf(c);
		
	}

	public int getNumberOfConnectedComponents() {
		ConnectivityInspector<Country, DefaultEdge> c = new ConnectivityInspector<>(grafo);
		return c.connectedSets().size() ;
	
	}

	public Map<Country, Integer> getCountryCounts() {
		for(Country co: grafo.vertexSet()) {
			if(!count.containsKey(co))
				count.put(co, this.grado(co));
		}
		return count;
	}
	public List<Country> loadAllCountries(){
		return dao.loadAllCountries();
	}
	public List<Country> trovaVicini( Graph<Country, DefaultEdge> grafo, Country partenza) {
		//BreadthFirstIterator<Country, DefaultEdge> it = new BreadthFirstIterator<>(grafo,partenza);
		return Graphs.neighborListOf(grafo, partenza);
		
	}
	
	
}
