/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_servicio_web_vent;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.inject.Named;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlSeeAlso;
import pkg_entidades.Venta;
@XmlSeeAlso({pkg_entidades.Venta.class})
/**
 *
 * @author Paúl
 */

@ManagedBean
@RequestScoped
@WebService(serviceName = "servicioweb_servidor_ven")
public class servicioweb_servidor_ven {

    Venta venta;
    ArrayList<Venta> list;
    public Venta getVenta() {
        return this.venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public ArrayList<Venta> getList() {
        return list;
    }

    public void setList(ArrayList<Venta> list) {
        this.list = list;
    }

    

    EntityManagerFactory factory=Persistence.createEntityManagerFactory("vent_servidorPU");
EntityManager em1=factory.createEntityManager(); @WebMethod(operationName = "insertar")
public int insertar(@WebParam(name = "ven_id") String ven_id, @WebParam(name = "clie_id") String clie_id,@WebParam(name = "usu_id") String usu_id,@WebParam(name = "ven_lugar") String ven_lugar,@WebParam(name = "ven_nombre") String ven_nombre)
{
    
String sql ="insert into ventas (ven_id,clie_id,usu_id,ven_lugar,ven_nombre) values ('"+ven_id+"'"+","+"'"+clie_id+"',"+"'"+usu_id+"',"+"'"+ven_lugar+"',"+"'"+ven_nombre+"')";
em1.getTransaction().begin();
Query qe=em1.createNativeQuery(sql); try
{
qe.executeUpdate(); em1.getTransaction().commit(); return 1;
}
catch (Exception ex)
{ em1.getTransaction().rollback();
return -1; }
}
@WebMethod(operationName = "eliminar")
public int eliminar(@WebParam(name = "ven_id") String ven_id) {
String sql ="delete from ventas where ven_id='"+ven_id+"'"; em1.getTransaction().begin();
Query qe=em1.createNativeQuery(sql);
int li_filas= qe.executeUpdate(); if (li_filas>=1)
{
em1.getTransaction().commit();
return 1; }
else {
em1.getTransaction().rollback();
return 0; }
}
@WebMethod(operationName = "modificar")
public int modificar(@WebParam(name = "ven_id") String ven_id,@WebParam(name = "clie_id") String clie_id,@WebParam(name = "usu_id") String usu_id,@WebParam(name = "ven_lugar") String ven_lugar,@WebParam(name = "ven_nombre") String ven_nombre)
{
String sql ="update ventas set clie_id='"+clie_id+"',usu_id='"+usu_id+"',ven_lugar='"+ven_lugar+"',ven_nombre='"+ven_nombre+"' where ven_id='"+ven_id+"'"; em1.getTransaction().begin();
Query qe=em1.createNativeQuery(sql);
int li_filas=qe.executeUpdate(); if (li_filas>=1)
{
em1.getTransaction().commit(); return 1;
} else {
em1.getTransaction().rollback(); return 0;
} }
public String buscar(@WebParam(name = "ven_id") String ven_id ) {
String sql ="select * from ventas where ven_id="+"'"+ven_id+"'"; Query qe=em1.createNativeQuery(sql);
List l1=qe.getResultList();
if (l1.size()>=1)
{
Object [] ar_objeto=(Object [])(l1.get(0)); String ls_nombre=ar_objeto[1].toString(); return ls_nombre;
} else {
return null; }
}

public ArrayList buscartodoooo( ) {
String sql ="select * from ventas"; Query qe=em1.createNativeQuery(sql);
List l1=qe.getResultList(); 
list=new ArrayList<>();
int a=0,b=1,c=2,d=3;
if (l1.size()>=1)
{
//Object [] ar_objeto=(Object [])(l1.get(0)); String ls_nombre=ar_objeto[1].toString(); return ls_nombre;
    for (int i = 0; i < l1.size(); i++) {
        Object [] ar_objeto=(Object [])(l1.get(i));
        
        list.add(new Venta(ar_objeto[0].toString(), ar_objeto[1].toString(), ar_objeto[2].toString(), ar_objeto[3].toString(),ar_objeto[4].toString()));
        System.out.println("hola "+list.get(i).getVen_nombre());
    }
} 

else {
return null; }

return list;
}
  
}
