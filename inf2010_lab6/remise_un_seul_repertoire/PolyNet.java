package PolyNet;

import java.util.HashSet;
import java.util.PriorityQueue;

public class PolyNet {
    private PolyNetNode[] nodes;

    public PolyNet(PolyNetNode[] nodes)
    {
        this.nodes = nodes;
    }

    // MST (using Prim's algorithm).
    public int computeTotalCableLength()
    {
    	
    	/*
    	On maintient les informations suivantes pour chaque noeud:
    	1. La distance de l'arete arrivant sur v depuis le sommet parent (dv)
    	2. Un booleen informant si le sommet est connu
    	3. Le parent a date du sommet v (pv)
    	
    	une file de priorite est egalement utilisee
    	 */
        int totalCableLength = 0;
        PriorityQueue<PolyNetConnection> knownConnections = new PriorityQueue<>();
        HashSet<PolyNetNode> visitedNodes = new HashSet<>();

        // À compléter
        // ajout
        
        visitedNodes.add(nodes[0]);
        for (PolyNetConnection distance : nodes[0].getConnections())
        	knownConnections.add(distance);
        while(!knownConnections.isEmpty()) {
        	
            PolyNetConnection d = knownConnections.remove();
            int distanceANodeCourant = d.getDistance();
            PolyNetNode v = d.getConnectedNode();
            
            if(!visitedNodes.contains(v)) {
                visitedNodes.add(v);
                for (PolyNetConnection distance : v.getConnections())
                	knownConnections.add(distance);
                totalCableLength += distanceANodeCourant;
            }
        }
        return totalCableLength;
    }
}
