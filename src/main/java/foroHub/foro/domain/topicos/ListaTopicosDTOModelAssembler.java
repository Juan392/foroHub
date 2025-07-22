package foroHub.foro.domain.topicos;

import lombok.NonNull;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ListaTopicosDTOModelAssembler implements RepresentationModelAssembler<ListaTopicosDTO, EntityModel<ListaTopicosDTO>> {

    @NonNull
    @Override
    public EntityModel<ListaTopicosDTO> toModel(@NonNull ListaTopicosDTO listaTopicosDTO) {
        return EntityModel.of(listaTopicosDTO);
    }

}