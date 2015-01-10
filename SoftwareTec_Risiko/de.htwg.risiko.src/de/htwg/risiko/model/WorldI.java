package de.htwg.risiko.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.htwg.risiko.model.CountryI;

/**
 * The Interface "WorldI" is implemented by "World" and provides an undirected graph, which connects Countries
 * 
 * @author Lars Knaack, Heiko Ettwein
 *
 */
public interface WorldI {

	/**
	 * Add a country-knot to the world-graph
	 * @param v Country to add
	 */
	void addCountry(CountryI v);
	
	/**
	 * Add a connecting edge between two countries
	 * @param v First country
	 * @param w Second country
	 */
 	void addEdge(CountryI v, CountryI w);
 	
 	/**
 	 * get a List of Countries, which are connected to a specific country through an edge
 	 * @param v Selected Country
 	 * @return a List of neighbours of the selected Country
 	 */
 	List<CountryI> getNeighbouringCountryList(CountryI v);
 	
 	/**
 	 * Check, if two countries a connected
 	 * @param v First country
 	 * @param w Second country
 	 * @return true, if they are connected
 	 */
 	boolean isNeighbour(CountryI v, CountryI w);
 	
 	/**
 	 * get the graph of Countries
 	 * @return a Map, representing the graph (Key = Country, Value = LinkedList of neighbours)
 	 */
 	Map<CountryI, LinkedList<CountryI>> getWorld();
}