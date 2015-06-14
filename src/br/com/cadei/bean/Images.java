package br.com.cadei.bean;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.cadei.dao.ClassDao;
import br.com.cadei.entidade.Aluno;

@ManagedBean
@ApplicationScoped
public class Images {

    @EJB
    private AlunoBean service;

    public StreamedContent getImage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }
        else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            String id = context.getExternalContext().getRequestParameterMap().get("objref");
            Aluno image = service.find(Integer.valueOf(id));
            return new DefaultStreamedContent(new ByteArrayInputStream(image.getImagem()));
        }
    }

}
