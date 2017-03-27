package controller;

import metier.Usager;
import dao.UsagerManager;

public class Usagercontroller {
	
	static UsagerManager UsagerManager;
	
	public Usagercontroller(){
		UsagerManager = new UsagerManager();	
	}
	
	public boolean addUsager( String nom,String prenom,String adresse,String tel){
		
		Usager u = new Usager( nom, prenom,adresse,tel);
		UsagerManager.ajouter(u);
		
		return false;
		
	}
	public void lister(){
		
		UsagerManager.lister();
	}
	public void UpdateUsager(String nom, String prenom,String adresse,String tel,int idr){
		
		Usager u = new Usager(nom,prenom,adresse,tel);
		UsagerManager.Modifier(u, idr);
		}
	public void deleteUsager(int id){
		UsagerManager.supprimer(id);
	}
	public void searchUsager(String nom){
		UsagerManager.Rechercher(nom);
	}
}
	