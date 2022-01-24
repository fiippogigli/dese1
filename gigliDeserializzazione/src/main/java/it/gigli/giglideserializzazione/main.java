package it.gigli.giglideserializzazione;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class main{
    public static void main( String[] args ) throws JsonParseException, JsonMappingException, IOException
    {
        //Deserializzazione e percorso file
        File file = new File("src/main/java/it/meucci/classe.xml"); 
        XmlMapper xmlMapper = new XmlMapper();
        root value = xmlMapper.readValue(file, root.class);
        System.out.println("La Classe " + value.getClasse() + " " + value.getSpecializzazione() + " e' nell'Aula " + value.getAula().getNome() + " e composta dagli Studenti:"); //stampo a schermo il conentuo del file XML
        
        //eseguo un ciclo FOR per stampare tutti gli STUDENTI contenuti nel Vettore
        for(int i = 0; i < value.getStudenti().size(); i++){
            System.out.println("- " + value.getStudenti().get(i).getCognome() + " " + value.getStudenti().get(i).getNome());}

        //Serializzazione FILE e stampo e Serializzo
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT); 
        xmlMapper.writeValue(new File("src/main/java/it/meucci/classeAgg.xml"), value);
        File newFile = new File("classeAgg.xml");
        
        //Serializzo
        String xml = xmlMapper.writeValueAsString(value);
        System.out.println("\n" + xml);
    }
}



