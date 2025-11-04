package trabalhoandre.alunoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import trabalhoandre.alunoapp.model.Aluno;
import trabalhoandre.alunoapp.service.AlunoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/")
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/aluno");
        mv.addObject("alunos", alunoService.findAll());

        return mv;
    }

    @GetMapping("/add")
    public ModelAndView add(Aluno aluno) {

        ModelAndView mv = new ModelAndView("/alunoAdd");
        mv.addObject("aluno", aluno);

        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {

        Aluno aluno = alunoService.findOne(id).get();

        ModelAndView mv = new ModelAndView("/alunoEdit");
        mv.addObject("aluno", aluno);

        return mv;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {

        alunoService.delete(id);

        return findAll();
    }

    @PostMapping("/save")
    public ModelAndView save(Aluno aluno, BindingResult result) {

        if (result.hasErrors()) {
            return add(aluno);
        }

        alunoService.save(aluno);

        return findAll();
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, Aluno aluno, BindingResult result) {

        if (result.hasErrors()) {
            return edit(id);
        }

        Aluno alunoEdit = alunoService.findOne(id).get();
        alunoEdit.setNome(aluno.getNome());
        alunoEdit.setSerie(aluno.getSerie());
        alunoEdit.setTexto(aluno.getTexto());
        alunoEdit.setGenero(aluno.getGenero());
        alunoEdit.setDataNascimento(aluno.getDataNascimento());

        alunoService.save(alunoEdit);

        return findAll();
    }

}
