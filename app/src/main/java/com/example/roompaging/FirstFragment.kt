package com.example.roompaging

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.room.User
import com.example.room.UserRepository
import com.example.roompaging.databinding.FragmentFirstBinding
import kotlinx.coroutines.*

class FirstFragment : Fragment() {

    private lateinit var viewModel: FirstFragmentViewModel
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        val androidViewModelFactory =
            ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
        viewModel = androidViewModelFactory.create(FirstFragmentViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUsers().subscribe(
            { list -> binding.recycler.adapter = UserAdapter(list) },
            { error -> error.printStackTrace() }
        )
    }
}


class FirstFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = UserRepository(application)
    fun getUsers() = repository.getAll()
    fun insertOrders(users: List<User>) = GlobalScope.launch {
        repository.insertAll(*users.toTypedArray())
    }

    init {
        Log.d("ViewModel", "Initialized")
    }
}

val mockUsers = listOf<User>(
    User(uid = 1, firstName = "Darrel", lastName = "Beadon", email = "dbeadon0@imageshack.us"),
    User(
        uid = 2,
        firstName = "Alie",
        lastName = "Cristoforetti",
        email = "acristoforetti1@blogspot.com"
    ),
    User(uid = 3, firstName = "Myrlene", lastName = "Ellissen", email = "mellissen2@usda.gov"),
    User(uid = 4, firstName = "Garth", lastName = "Spendley", email = "gspendley3@mapquest.com"),
    User(uid = 5, firstName = "Gorden", lastName = "Cholomin", email = "gcholomin4@webs.com"),
    User(
        uid = 6,
        firstName = "Melisent",
        lastName = "Shutte",
        email = "mshutte5@deliciousdays.com"
    ),
    User(uid = 7, firstName = "Tabb", lastName = "Spinney", email = "tspinney6@posterous.com"),
    User(
        uid = 8,
        firstName = "Barthel",
        lastName = "Kilfedder",
        email = "bkilfedder7@sourceforge.net"
    ),
    User(uid = 9, firstName = "Gladi", lastName = "McCullock", email = "gmccullock8@latimes.com"),
    User(uid = 10, firstName = "Lamont", lastName = "Dulen", email = "ldulen9@vimeo.com"),
    User(uid = 11, firstName = "Norrie", lastName = "Viscovi", email = "nviscovia@who.int"),
    User(uid = 12, firstName = "Betteanne", lastName = "Mabley", email = "bmableyb@mashable.com"),
    User(uid = 13, firstName = "Kipp", lastName = "Halton", email = "khaltonc@prnewswire.com"),
    User(uid = 14, firstName = "Marji", lastName = "Casale", email = "mcasaled@51.la"),
    User(
        uid = 15,
        firstName = "Konstantin",
        lastName = "Caseri",
        email = "kcaserie@businessinsider.com"
    ),
    User(uid = 16, firstName = "Terry", lastName = "McGucken", email = "tmcguckenf@reference.com"),
    User(uid = 17, firstName = "Mason", lastName = "Brou", email = "mbroug@comsenz.com"),
    User(uid = 18, firstName = "Cybil", lastName = "Spivie", email = "cspivieh@who.int"),
    User(
        uid = 19,
        firstName = "Keeley",
        lastName = "Pettifor",
        email = "kpettifori@cocolog-nifty.com"
    ),
    User(
        uid = 20,
        firstName = "Munroe",
        lastName = "De",
        email = "Blasiismdeblasiisj@guardian.co.uk"
    ),
    User(uid = 21, firstName = "Ferdy", lastName = "Admans", email = "fadmansk@hatena.ne.jp"),
    User(uid = 22, firstName = "Fey", lastName = "Ahrend", email = "fahrendl@naver.com"),
    User(uid = 23, firstName = "Gabie", lastName = "Hardy", email = "ghardym@taobao.com"),
    User(uid = 24, firstName = "Kimbell", lastName = "Van", email = "Veldenkvanveldenn@paypal.com"),
    User(uid = 25, firstName = "Tyne", lastName = "Maly", email = "tmalyo@telegraph.co.uk"),
    User(uid = 26, firstName = "Thornton", lastName = "Dennert", email = "tdennertp@hatena.ne.jp"),
    User(uid = 27, firstName = "Helaine", lastName = "Piggins", email = "hpigginsq@chron.com"),
    User(uid = 28, firstName = "Maryellen", lastName = "Lober", email = "mloberr@typepad.com"),
    User(uid = 29, firstName = "Eileen", lastName = "Bradmore", email = "ebradmores@uiuc.edu"),
    User(uid = 30, firstName = "Napoleon", lastName = "Spuner", email = "nspunert@google.co.jp"),
    User(uid = 31, firstName = "Aldus", lastName = "Smullin", email = "asmullinu@wisc.edu"),
    User(uid = 32, firstName = "Augy", lastName = "Brennen", email = "abrennenv@bloglines.com"),
    User(uid = 33, firstName = "Debor", lastName = "Dressell", email = "ddressellw@google.ca"),
    User(uid = 34, firstName = "Jessi", lastName = "Robertis", email = "jrobertisx@answers.com"),
    User(uid = 35, firstName = "Leisha", lastName = "Riggey", email = "lriggeyy@alibaba.com"),
    User(uid = 36, firstName = "Stesha", lastName = "Castlake", email = "scastlakez@last.fm"),
    User(uid = 37, firstName = "Bobbee", lastName = "Crim", email = "bcrim10@intel.com"),
    User(uid = 38, firstName = "Sharyl", lastName = "Casserley", email = "scasserley11@is.gd"),
    User(uid = 39, firstName = "Gracia", lastName = "Mouat", email = "gmouat12@github.io"),
    User(uid = 40, firstName = "Zacharias", lastName = "Larman", email = "zlarman13@ca.gov"),
    User(uid = 41, firstName = "Ryley", lastName = "Karim", email = "rkarim14@reverbnation.com"),
    User(uid = 42, firstName = "Erminia", lastName = "Bines", email = "ebines15@t.co"),
    User(uid = 43, firstName = "Mic", lastName = "Winspear", email = "mwinspear16@bbb.org"),
    User(uid = 44, firstName = "Debera", lastName = "Pullen", email = "dpullen17@ask.com"),
    User(uid = 45, firstName = "Staffard", lastName = "Cooksley", email = "scooksley18@google.it"),
    User(uid = 46, firstName = "Onida", lastName = "Begwell", email = "obegwell19@loc.gov"),
    User(
        uid = 47,
        firstName = "Ced",
        lastName = "Cardenas",
        email = "ccardenas1a@scientificamerican.com"
    ),
    User(uid = 48, firstName = "Tammy", lastName = "Vaen", email = "tvaen1b@studiopress.com"),
    User(uid = 49, firstName = "Xenia", lastName = "Treleven", email = "xtreleven1c@last.fm"),
    User(uid = 50, firstName = "Tillie", lastName = "Stickel", email = "tstickel1d@360.cn"),
    User(
        uid = 51,
        firstName = "Jenelle",
        lastName = "Brownsell",
        email = "jbrownsell1e@chicagotribune.com"
    ),
    User(uid = 52, firstName = "Nestor", lastName = "Jakoubec", email = "njakoubec1f@mit.edu"),
    User(uid = 53, firstName = "Erna", lastName = "Need", email = "eneed1g@earthlink.net"),
    User(
        uid = 54,
        firstName = "Zolly",
        lastName = "Giannazzi",
        email = "zgiannazzi1h@discovery.com"
    ),
    User(
        uid = 55,
        firstName = "Marcel",
        lastName = "Domenichini",
        email = "mdomenichini1i@hatena.ne.jp"
    ),
    User(uid = 56, firstName = "Manny", lastName = "Owbrick", email = "mowbrick1j@friendfeed.com"),
    User(uid = 57, firstName = "Rivalee", lastName = "Dunaway", email = "rdunaway1k@ucsd.edu"),
    User(uid = 58, firstName = "Ganny", lastName = "McNeillie", email = "gmcneillie1l@adobe.com"),
    User(uid = 59, firstName = "Travis", lastName = "Kochlin", email = "tkochlin1m@mlb.com"),
    User(uid = 60, firstName = "Lynnea", lastName = "Durdle", email = "ldurdle1n@indiatimes.com"),
    User(uid = 61, firstName = "Aurthur", lastName = "Strahan", email = "astrahan1o@zimbio.com"),
    User(uid = 62, firstName = "Culley", lastName = "Huggon", email = "chuggon1p@facebook.com"),
    User(uid = 63, firstName = "Sarita", lastName = "Everiss", email = "severiss1q@netlog.com"),
    User(uid = 64, firstName = "Lacee", lastName = "Danzelman", email = "ldanzelman1r@last.fm"),
    User(uid = 65, firstName = "Lynn", lastName = "Bosley", email = "lbosley1s@prlog.org"),
    User(uid = 66, firstName = "Elyssa", lastName = "Wordington", email = "ewordington1t@npr.org"),
    User(uid = 67, firstName = "Retha", lastName = "Foulds", email = "rfoulds1u@dot.gov"),
    User(uid = 68, firstName = "Polly", lastName = "Faraday", email = "pfaraday1v@accuweather.com"),
    User(uid = 69, firstName = "Garik", lastName = "Ventham", email = "gventham1w@nsw.gov.au"),
    User(uid = 70, firstName = "Meggy", lastName = "Oxley", email = "moxley1x@yelp.com"),
    User(
        uid = 71,
        firstName = "Olivero",
        lastName = "Bissiker",
        email = "obissiker1y@cyberchimps.com"
    ),
    User(uid = 72, firstName = "Moina", lastName = "Stickel", email = "mstickel1z@abc.net.au"),
    User(uid = 73, firstName = "Salim", lastName = "Blowing", email = "sblowing20@jiathis.com"),
    User(uid = 74, firstName = "Mel", lastName = "Danilyuk", email = "mdanilyuk21@ask.com"),
    User(uid = 75, firstName = "Carena", lastName = "Bourchier", email = "cbourchier22@cam.ac.uk"),
    User(uid = 76, firstName = "Elysha", lastName = "Brychan", email = "ebrychan23@devhub.com"),
    User(uid = 77, firstName = "Dunn", lastName = "Luipold", email = "dluipold24@pen.io"),
    User(
        uid = 78,
        firstName = "Hermine",
        lastName = "Falla",
        email = "hfalla25@businessinsider.com"
    ),
    User(uid = 79, firstName = "Dwight", lastName = "Demangeot", email = "ddemangeot26@t.co"),
    User(uid = 80, firstName = "Jody", lastName = "Pratten", email = "jpratten27@a8.net"),
    User(uid = 81, firstName = "Bradney", lastName = "Astlett", email = "bastlett28@gizmodo.com"),
    User(uid = 82, firstName = "Marabel", lastName = "McGinney", email = "mmcginney29@histats.com"),
    User(uid = 83, firstName = "Amalea", lastName = "Drover", email = "adrover2a@jalbum.net"),
    User(uid = 84, firstName = "Arie", lastName = "Bacop", email = "abacop2b@japanpost.jp"),
    User(
        uid = 85,
        firstName = "Winifred",
        lastName = "Fisbburne",
        email = "wfisbburne2c@elegantthemes.com"
    ),
    User(uid = 86, firstName = "Colby", lastName = "Moehler", email = "cmoehler2d@alexa.com"),
    User(uid = 87, firstName = "Cathleen", lastName = "Whisby", email = "cwhisby2e@auda.org.au"),
    User(
        uid = 88,
        firstName = "Jorgan",
        lastName = "Ivanyukov",
        email = "jivanyukov2f@businessinsider.com"
    ),
    User(
        uid = 89,
        firstName = "Cullen",
        lastName = "Pettegre",
        email = "cpettegre2g@barnesandnoble.com"
    ),
    User(uid = 90, firstName = "Hilary", lastName = "Goublier", email = "hgoublier2h@paypal.com"),
    User(uid = 91, firstName = "Bertrand", lastName = "Gamage", email = "bgamage2i@tamu.edu"),
    User(uid = 92, firstName = "Emmye", lastName = "Larraway", email = "elarraway2j@forbes.com"),
    User(
        uid = 93,
        firstName = "Drusie",
        lastName = "Spadollini",
        email = "dspadollini2k@seesaa.net"
    ),
    User(uid = 94, firstName = "Marabel", lastName = "Ullyatt", email = "mullyatt2l@drupal.org"),
    User(uid = 95, firstName = "Reube", lastName = "Cliburn", email = "rcliburn2m@plala.or.jp"),
    User(uid = 96, firstName = "Elke", lastName = "Janik", email = "ejanik2n@canalblog.com"),
    User(
        uid = 97,
        firstName = "Dorisa",
        lastName = "Wiltsher",
        email = "dwiltsher2o@washington.edu"
    ),
    User(uid = 98, firstName = "Eduino", lastName = "Davenell", email = "edavenell2p@usatoday.com"),
    User(uid = 99, firstName = "Mame", lastName = "Cohani", email = "mcohani2q@wikimedia.org"),
    User(
        uid = 100,
        firstName = "Shantee",
        lastName = "Lidington",
        email = "slidington2r@cargocollective.com"
    )
)


