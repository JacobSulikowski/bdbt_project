package bada_bdbt_proj.OperatorSieciKablowej;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration @Controller
public class AppController implements WebMvcConfigurer {

    @Autowired
    private PracownicyDAO pracownicyDAO;
    @Autowired
    private PocztyDAO pocztyDAO;
    @Autowired
    private AdresyDAO adresyDAO;
    @Autowired
    private LokaleDAO lokaleDAO;
    @Autowired
    private AbonenciDAO abonenciDAO;
    @Autowired
    private UslugiDAO uslugiDAO;
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
    }
    @Controller
    public class DashboardController {
        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            }
            else
            {
                return "redirect:/index";
            }
        }
    }
    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }

    @RequestMapping("/pracownicy")
    public String showPracownicyPage(Model model){
        List<Pracownik> listPracownik = pracownicyDAO.list();
        model.addAttribute("listPracownik", listPracownik);
        return "tabele/pracownicy/pracownicy";
    }
    @RequestMapping("/poczty")
    public String showPocztyPage(Model model){
        List<Poczta> listPoczty = pocztyDAO.list();
        model.addAttribute("listPoczty", listPoczty);
        return "tabele/poczty/poczty";
    }
    @RequestMapping("/adresy")
    public String showAdresyPage(Model model){
        List<Adres> listAdresy = adresyDAO.list();
        model.addAttribute("listAdresy", listAdresy);
        return "tabele/adresy/adresy";
    }
    @RequestMapping("/lokale")
    public String showLokalePage(Model model){
        List<Lokal> listLokal = lokaleDAO.list();
        model.addAttribute("listLokal", listLokal);
        return "tabele/lokale/lokale";
    }
    @RequestMapping("/abonenci")
    public String showAbonenciPage(Model model){
        List<Abonent> listAbonent = abonenciDAO.list();
        model.addAttribute("listAbonent", listAbonent);
        return "tabele/abonenci/abonenci";
    }
    @RequestMapping("/uslugi")
    public String showUslugiPage(Model model){
        List<Usluga> listUsluga = uslugiDAO.list();
        model.addAttribute("listUsluga", listUsluga);
        return "tabele/uslugi/uslugi";
    }
    @RequestMapping("/uslugi_u")
    public String showUslugiLPage(Model model){
        List<Usluga> listUsluga = uslugiDAO.list();
        model.addAttribute("listUsluga", listUsluga);
        return "tabele/uslugi/uslugi_u";
    }

    @RequestMapping("/nowy_pracownik")
    public String showNewPracownikPage(Model model){
        Pracownik pracownik = new Pracownik();
        model.addAttribute("pracownik", pracownik);
        return "tabele/pracownicy/nowy_pracownik";
    }
    @RequestMapping("/nowa_poczta")
    public String showNewPocztaPage(Model model){
        Poczta poczta = new Poczta();
        model.addAttribute("poczta", poczta);
        return "tabele/poczty/nowa_poczta";
    }

    @RequestMapping("/nowy_adres")
    public String showNewAdresPage(Model model){
        Adres adres = new Adres();
        model.addAttribute("adres", adres);
        return "tabele/adresy/nowy_adres";
    }

    @RequestMapping("/nowy_lokal")
    public String showNewLokalPage(Model model){
        Lokal lokal = new Lokal();
        model.addAttribute("lokal", lokal);
        return "tabele/lokale/nowy_lokal";
    }
    @RequestMapping("/nowy_abonent")
    public String showNewAbonentPage(Model model){
        Abonent abonent = new Abonent();
        model.addAttribute("abonent", abonent);
        return "tabele/abonenci/nowy_abonent";
    }
    @RequestMapping("/twoj_profil")
    public String showNewProfilPage(Model model){
        Abonent abonent = new Abonent();
        model.addAttribute("abonent", abonent);
        return "user/twoj_profil";
    }
    @RequestMapping("/nowa_usluga")
    public String showNewAUslugaPage(Model model){
        Usluga usluga = new Usluga();
        model.addAttribute("usluga", usluga);
        return "tabele/uslugi/nowa_usluga";
    }

   @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("pracownik") Pracownik pracownik){
        pracownicyDAO.save(pracownik);

        return "redirect:/pracownicy";
    }
    @RequestMapping(value = "/savePoczta", method = RequestMethod.POST)
    public String save(@ModelAttribute("poczta") Poczta poczta){
        pocztyDAO.save(poczta);

        return "redirect:/poczty";
    }


    @RequestMapping(value = "/saveAdres", method = RequestMethod.POST)
    public String save(@ModelAttribute("adres") Adres adres){
        adresyDAO.save(adres);

        return "redirect:/adresy";
    }

    @RequestMapping(value = "/saveLokal", method = RequestMethod.POST)
    public String save(@ModelAttribute("lokal") Lokal lokal){
        lokaleDAO.save(lokal);

        return "redirect:/lokale";
    }
    @RequestMapping(value = "/saveAbonent", method = RequestMethod.POST)
    public String save(@ModelAttribute("abonent") Abonent abonent){
        abonenciDAO.save(abonent);

        return "redirect:/abonenci";
    }
    @RequestMapping(value = "/saveUsluga", method = RequestMethod.POST)
    public String save(@ModelAttribute("usluga") Usluga usluga){
        uslugiDAO.save(usluga);

        return "redirect:/uslugi";
    }

    @RequestMapping("/edit/{idPracownika}")
    public ModelAndView showEditForm(@PathVariable(name = "idPracownika") int idPracownika){
        ModelAndView mav = new ModelAndView("tabele/pracownicy/edytuj_dane_pracownika");
        Pracownik pracownik = pracownicyDAO.get(idPracownika);
        mav.addObject("pracownik", pracownik);

        return mav;
    }
    @RequestMapping("/editPoczta/{nrPoczty}")
    public ModelAndView showEditFormPoczta(@PathVariable(name = "nrPoczty") int nrPoczty){
        ModelAndView mav = new ModelAndView("tabele/poczty/edytuj_dane_poczty");
        Poczta poczta = pocztyDAO.get(nrPoczty);
        mav.addObject("poczta", poczta);

        return mav;
    }

    @RequestMapping("/editAdres/{nrAdresu}")
    public ModelAndView showEditFormAdres(@PathVariable(name = "nrAdresu") int nrAdresu){
        ModelAndView mav = new ModelAndView("tabele/adresy/edytuj_dane_adresu");
        Adres adres = adresyDAO.get(nrAdresu);
        mav.addObject("adres", adres);

        return mav;
    }

    @RequestMapping("/editLokal/{idLokalu}")
    public ModelAndView showEditFormLokal(@PathVariable(name = "idLokalu") int idLokalu){
        ModelAndView mav = new ModelAndView("tabele/lokale/edytuj_dane_lokalu");
        Lokal lokal = lokaleDAO.get(idLokalu);
        mav.addObject("lokal", lokal);

        return mav;
    }
    @RequestMapping("/editAbonent/{idAbonenta}")
    public ModelAndView showEditFormAbonenci(@PathVariable(name = "idAbonenta") int idAbonenta){
        ModelAndView mav = new ModelAndView("tabele/abonenci/edytuj_dane_abonenta");
        Abonent abonent = abonenciDAO.get(idAbonenta);
        mav.addObject("abonent", abonent);

        return mav;
    }
    @RequestMapping("/editUsluga/{idUslugi}")
    public ModelAndView showEditFormUslugi(@PathVariable(name = "idUslugi") int idUslugi){
        ModelAndView mav = new ModelAndView("tabele/uslugi/edytuj_dane_uslugi");
        Usluga usluga = uslugiDAO.get(idUslugi);
        mav.addObject("usluga", usluga);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("pracownik") Pracownik pracownik){
        pracownicyDAO.update(pracownik);
        return "redirect:/pracownicy";
    }
    @RequestMapping(value = "/updatePoczta", method = RequestMethod.POST)
    public String update(@ModelAttribute("poczta") Poczta poczta){
        pocztyDAO.update(poczta);
        return "redirect:/poczty";
    }

    @RequestMapping(value = "/updateAdres", method = RequestMethod.POST)
    public String update(@ModelAttribute("adres") Adres adres){
        adresyDAO.update(adres);
        return "redirect:/adresy";
    }

    @RequestMapping(value = "/updateLokal", method = RequestMethod.POST)
    public String update(@ModelAttribute("lokal") Lokal lokal){
        lokaleDAO.update(lokal);
        return "redirect:/lokale";
    }
    @RequestMapping(value = "/updateAbonent", method = RequestMethod.POST)
    public String update(@ModelAttribute("abonent") Abonent abonent){
        abonenciDAO.update(abonent);
        return "redirect:/abonenci";
    }
    @RequestMapping(value = "/updateUsluga", method = RequestMethod.POST)
    public String update(@ModelAttribute("usluga") Usluga usluga){
        uslugiDAO.update(usluga);
        return "redirect:/uslugi";
    }

    @RequestMapping("/delete/{idPracownika}")
    public String delete(@PathVariable(name = "idPracownika") int idPracownika){
        pracownicyDAO.delete(idPracownika);

        return "redirect:/pracownicy";
    }
    @RequestMapping("/deletePoczta/{nrPoczty}")
    public String deletePoczta(@PathVariable(name = "nrPoczty") int nrPoczty){
        pocztyDAO.delete(nrPoczty);

        return "redirect:/poczty";
    }

    @RequestMapping("/deleteAdres/{nrAdresu}")
    public String deleteAdres(@PathVariable(name = "nrAdresu") int nrAdresu){
        adresyDAO.delete(nrAdresu);

        return "redirect:/adresy";
    }
    @RequestMapping("/deleteLokal/{idLokalu}")
    public String deleteLokal(@PathVariable(name = "idLokalu") int idLokalu){
        lokaleDAO.delete(idLokalu);

        return "redirect:/lokale";
    }
    @RequestMapping("/deleteAbonent/{idAbonenta}")
    public String deleteAbonent(@PathVariable(name = "idAbonenta") int idAbonenta){
        abonenciDAO.delete(idAbonenta);

        return "redirect:/abonenci";
    }
    @RequestMapping("/deleteUsluga/{idUslugi}")
    public String deleteUsluga(@PathVariable(name = "idUslugi") int idUslugi){
        uslugiDAO.delete(idUslugi);

        return "redirect:/uslugi";
    }

}