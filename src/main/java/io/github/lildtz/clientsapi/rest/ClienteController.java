package io.github.lildtz.clientsapi.rest;

import io.github.lildtz.clientsapi.model.entity.Cliente;
import io.github.lildtz.clientsapi.model.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody @Valid Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente findById(@PathVariable Integer id) {
        return clienteRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Cliente não encontrado!")
        );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar( @PathVariable Integer id) {
        clienteRepository.findById(id).map( cliente -> {
            clienteRepository.delete(cliente);
            return Void.TYPE;
        }).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado!")
        );
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar( @PathVariable Integer id, @RequestBody @Valid Cliente clienteAtualizado) {
        clienteRepository.findById(id).map( cliente -> {
            clienteAtualizado.setId(cliente.getId());
            return clienteRepository.save(clienteAtualizado);
        }).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado!")
        );
    }
}
