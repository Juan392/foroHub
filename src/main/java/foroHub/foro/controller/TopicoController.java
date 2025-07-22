package foroHub.foro.controller;


import foroHub.foro.domain.topicos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.hateoas.EntityModel;

@RestController
@RequestMapping("/forohub")
public class TopicoController {
    @Autowired
    public TopicoRepository repository;

    @Autowired
    public ListaTopicosDTOModelAssembler listaTopicosDTOModelAssembler;
    @Autowired
    PagedResourcesAssembler<ListaTopicosDTO> pagedResourcesAssembler;

    @Transactional
    @PostMapping
    public ResponseEntity publicar(@RequestBody @Valid RegistroTopicoDTO datos, UriComponentsBuilder uriComponentsBuilder){
        var topico = new Topicos(datos);
        repository.save(topico);
        var uri = uriComponentsBuilder.path("/foro/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetallesTopicoDTO(topico));
    }

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<ListaTopicosDTO>>> listar(@PageableDefault(size = 10, sort = {"autor", "fechaDeCreacion"}) Pageable paginacion){
        Page<ListaTopicosDTO> lista= repository.findAll(paginacion).map(ListaTopicosDTO::new);
        return ResponseEntity.ok(pagedResourcesAssembler.toModel(lista,listaTopicosDTOModelAssembler));
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id){
        var detalles = repository.getReferenceById(id);
        return  ResponseEntity.ok(new DetallesTopicoDTO(detalles));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody @Valid ActualizarTopicoDTO datos){
        var topico = repository.getReferenceById(id);
        topico.actualizarTopico(datos);
        return ResponseEntity.ok(new DetallesTopicoDTO(topico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity elimiar(@PathVariable Long id){
        //No es recomendable hacer borrado fisico, pero aqui lo pide, pero si es posible siempre recurrir a borrado logico
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
