package br.com.alura.loja.resource;

import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Projeto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("projetos")
public class ProjetoResource {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Projeto busca(@PathParam("id") Long id) {
		return new ProjetoDAO().busca(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response adiciona(Projeto projeto) {
		new ProjetoDAO().adiciona(projeto);
		URI uri = URI.create("/carrinhos/" + projeto.getId());
		return Response.created(uri).build();
	}

	@DELETE
	@Path("{id}")
	public Response removeProjeto(@PathParam("id") Long id) {
		new ProjetoDAO().remove(id);
		return Response.ok().build();
	}

}
