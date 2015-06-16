-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 16, 2015 at 05:48 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `getbetter`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE IF NOT EXISTS `answer` (
  `answerID` int(11) NOT NULL AUTO_INCREMENT,
  `ans` int(11) NOT NULL,
  PRIMARY KEY (`answerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `categoryID` int(11) NOT NULL,
  `categoryName` varchar(30) NOT NULL,
  PRIMARY KEY (`categoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`categoryID`, `categoryName`) VALUES
(1, 'Paganay'),
(2, 'Fever'),
(3, 'Cough'),
(4, 'Tummy Pain'),
(5, 'Diarrhea'),
(6, 'Ear Problems'),
(7, 'Skin Problems'),
(8, 'Eye Problems'),
(9, 'Child Failing To Thrive');

-- --------------------------------------------------------

--
-- Table structure for table `inputtext`
--

CREATE TABLE IF NOT EXISTS `inputtext` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `step` int(11) NOT NULL,
  `textTypeID` enum('1','2','3') NOT NULL,
  `intentTypeID` enum('1','2') NOT NULL,
  `engText` text NOT NULL,
  `filText` text,
  `engYes` varchar(15) NOT NULL,
  `engNo` varchar(15) NOT NULL,
  `filYes` text,
  `filNo` text,
  `yesNext` int(11) NOT NULL,
  `noNext` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `textTypeID` (`textTypeID`),
  KEY `intentTypeID` (`intentTypeID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=153 ;

--
-- Dumping data for table `inputtext`
--

INSERT INTO `inputtext` (`ID`, `step`, `textTypeID`, `intentTypeID`, `engText`, `filText`, `engYes`, `engNo`, `filYes`, `filNo`, `yesNext`, `noNext`) VALUES
(2, 1, '1', '2', 'Does the patient refuse to take breastmilk?', 'Ayaw ba uminom ng gatas ng bata?', 'Yes', 'No', 'Oo', 'Hindi', -1, 2),
(3, 1, '1', '2', 'Does the patient vomit everything?', 'Sinusuka ba ng bata lahat ng ipinapakain sa kanya?', 'Yes', 'No', 'Oo', 'Hindi', -1, 2),
(32, 1, '1', '2', 'Is the patient having seizures?', 'Nagkakaroon po ba ng kumbulsyon ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', -1, 2),
(57, 1, '1', '2', 'Is the patient very sleepy, cannot be awakened easily?', 'Ang pasyente ba ay masyadong inaantok o mahirap gisingin?', 'Yes', 'No', 'Oo', 'Hindi', -1, 2),
(58, 1, '1', '2', 'Does the patient have very hard breathing?', 'Nahihirapan ba huminga ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', -1, 2),
(59, 1, '1', '2', 'Is the sick baby under two months old?', 'Mas bata ba sa dalawang buwan ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', -1, 2),
(60, 2, '1', '1', 'Is the temperature higher than 37.5?', 'Mas mataas ba sa 37.5 ang temperatura ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 3, 6),
(61, 2, '1', '1', ' Does the mother report a fever in the last three days?', 'May lagnat ba ang pasyente sa nakaraang tatlong araw?', 'Yes', 'No', 'Oo', 'Hindi', 3, 6),
(62, 3, '1', '1', 'Are there signs of Ear drainage? ', 'May umaagos ba sa tainga ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 19, 4),
(63, 3, '1', '1', 'Are there signs of Cold symptoms?', 'May sipon po ba kayo?', 'Yes', 'No', 'Oo', 'Hindi', 0, 4),
(64, 3, '1', '1', 'Are there signs of Sore throat?', 'Masakit po ba ang inyong lalamunan?', 'Yes', 'No', 'Oo', 'Hindi', 0, 4),
(65, 3, '1', '1', 'Are there signs of Cough?', 'May ubo po ba kayo?', 'Yes', 'No', 'Oo', 'Hindi', 6, 4),
(66, 3, '1', '1', 'Are there signs of Rash  like Measles or other?', 'May mga pantal ba ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 5, 4),
(67, 3, '1', '1', 'Are there signs of pain when urinating?', 'May nararamdaman po ba kayong sakit tuwing kayo ay umiihi?', 'Yes', 'No', 'Oo', 'Hindi', 14, 4),
(68, 3, '1', '1', 'Are there signs of any visible infection on the body?', 'May mga nakikitang impeksyon ba sa katawan ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 8, 1),
(69, 4, '1', '1', 'Does the patient experience fever everyday for a week or more and came on gradually?', 'Nilalagnat ba ang pasyente araw-araw ng isang linggo o mahigit at pabalik-balik ang lagnat?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(70, 4, '1', '1', 'Does the fever of the patient responds to Paracetamol?', 'Tumatalab ba ang Paracetamol sa lagnat ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(71, 4, '1', '1', 'Does the fever of the patient never goes away or not intermittent?', 'Hindi ba nawawala ang lagnat ng pasyente at patuloy-tuloy?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(72, 4, '1', '1', 'Does the patient find it hard to sleep and has very poor appetite?', 'Mahirap ba makatulog ang pasyente at hindi masyadong nakain?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(73, 4, '1', '1', 'Does the pulse of the patient slower than expected for fever?', 'Mabagal ba ang pulso ng pasyente para sa lagnat?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(74, 4, '1', '2', 'Does the patient think slow or is easily confused?', 'Madali bang malito ang pasyente o mabagal magisip?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(75, 4, '1', '1', 'Does the fever and pain came on suddenly?', 'Bigla na lang ba nagkaron ng lagnat ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(76, 4, '1', '2', 'Does the patient experience very painful eyes or back?', 'Masakit ba ang mata o ang likod ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(77, 4, '1', '2', 'Does the patient experience petichial or fleeting rash, like little blood spots, or quickly fading itchy rash?', 'Nagkakaron ba ang pasyente ng mga pantal na madaling nawawala?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(78, 4, '1', '2', 'Is the patient very weak?', 'Nanghihina ba sobra ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(79, 4, '1', '2', 'Does the patient experience bleeding in feces?', 'Meron bang dugo kapag nagdudumi ang pasyente?', 'Yes', 'No', 'Meron', 'Wala', 0, 0),
(80, 5, '1', '2', 'Does the patient show signs of red eyes?', 'Namumula ba ang mga mata ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 0, 6),
(81, 5, '1', '1', 'Does the patient show signs of a flat rash beginning behind ears, red, to brown?', 'Meron bang pantal ang pasyente sa likod ng tenga na kulay pula?', 'Yes', 'No', 'Meron', 'Wala', 0, 6),
(82, 6, '1', '2', 'For a child more than 1 year old, does the child breathe more than 40 times per minute?', 'Para sa bata na ang edad ay isa pataas, ang paghinga ba ng bata ay more than 40 times sa isang minuto?', 'Yes', 'No', 'Oo', 'Hindi', 0, 9),
(83, 6, '1', '2', 'For a child less than 1 year old, does the child breathe more than 50 times per minute?', 'Para sa bata na ang edad ay isa pababa, ang paghinga ba ng bata ay more than 50 times sa isang minuto?', 'Yes', 'No', 'Oo', 'Hindi', 0, 9),
(84, 6, '1', '1', 'Does the child has retractions or nose flaring?\r\n', 'Lumalaki ba ang butas ng ilong ng bata kapag humihinga?', 'Yes', 'No', 'Oo', 'Hindi', 0, 9),
(85, 7, '1', '1', 'Is there a wheezing sound when the patient breathes?', 'May tunog ba na parang sipol kapag humihinga ang pasyente?', 'Yes', 'No', 'Meron', 'Wala', 8, 8),
(86, 6, '1', '1', 'Is there any sound when the patient is breathing?', 'Meron bang tunog kapag humihinga ang pasyente?', 'Yes', 'No', 'Meron', 'Wala', 0, 9),
(87, 6, '1', '1', 'Is the patient breathing very fast (30/min)?', 'Masyado bang mabilis ang paghinga ng pasyente(30/min)?', 'Yes', 'No', 'Oo', 'Hindi', 0, 9),
(88, 7, '1', '1', 'Is there a sound like water gurgling or rattling when the patient breathes?', 'May tunog ba na parang may tubig kapag humihinga ang pasyente?', 'Yes', 'No', 'Meron', 'Wala', 8, 8),
(89, 8, '1', '1', 'Does the patient cough up blood?', 'May dugo ba kapag umuubo ang pasyente?', 'Yes', 'No', 'Meron', 'Wala', 9, 9),
(90, 8, '1', '1', 'Is the patient been coughing for more than one month?', 'Mahigit isang buwan na ba ang pagubo ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 9, 9),
(91, 8, '1', '1', 'Did the patient grew thin in the last month?', 'Nangayayat ba ang pasyente sa nagdaang buwan?', 'Yes', 'No', 'Oo', 'Hindi', 9, 9),
(92, 8, '1', '1', 'Does the patient have slight fevers frequently especially at night?', 'Madalas bang magkaroon ng bahagyang lagnat ang pasyente lalo na sa gabi?', 'Yes', 'No', 'Oo', 'Hindi', 9, 9),
(93, 8, '1', '1', 'Does the patient experience chest pain?', 'Masakit ba ang dibdib ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 9, 9),
(94, 8, '1', '1', 'If the patient is a child, did the patient just recover from measles but not regaining strength or weight, and continues to cough?', 'Kung ang pasyente ay bata, kagagaling lang ba sa sakit na tigdas ang bata ngunit hindi pa nanunumbalik ang lakas o timabang, at patuloy pa din ang pag ubo?', 'Yes', 'No', 'Oo', 'Hindi', 9, 9),
(95, 8, '1', '1', 'If the patient is a child, does the child have a lymph node at the neck or the upper clavicle area?', 'Kung ang pasyente ay bata, meron bang lymph node ang bata sa kanyang leeg?', 'Yes', 'No', 'Meron', 'Wala', 9, 9),
(96, 9, '1', '1', 'Does the patient have stomach pain?', 'Ang pasyente ba ay nakararanas ng sakit sa tiyan?', 'Yes', 'No', 'Oo', 'Hindi', 10, 15),
(97, 10, '1', '1', 'Is the stomach pain of the patient steady?', 'Ang sakit ng tiyan ba ng pasyente ay hindi nawawala?', 'Yes', 'No', 'Oo', 'Hindi', 11, 14),
(98, 10, '1', '1', 'Is the pain on the lower right side of the patient''s abdomen?', 'Ang sakit ba na nararamdaman ng pasyente ay nasa ibabang-kanan ng tiyan?', 'Yes', 'No', 'Oo', 'Hindi', 11, 13),
(99, 10, '1', '1', 'Did the patient vomit?', 'Sumuka ba ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 11, 13),
(100, 11, '1', '1', 'Is there any bowel sounds (tinkling, gurgling) in the patient''s stomach?', 'Meron bang tunog na parang may tubig sa tiyan ng pasyente?', 'Yes', 'No', 'Meron', 'Wala', 12, 0),
(101, 12, '1', '1', 'Is the patient''s stomach pain only painful in the lower right part, not other places?', 'Ang sakit ba na nararamdaman ng pasyente sa kanyang tiyan ay nasa ibabang-kanan lang at wala sa ibang lugar?', 'Yes', 'No', 'Oo', 'Hindi', 0, 13),
(102, 12, '1', '1', 'Is the patient''s stomach pain hurt mostly high up, near under the ribs?', 'Ang sakit ba na nararamdaman ng pasyente ay nasa bandang itaas ng tiyan malapit sa baba ng tadyang?', 'Yes', 'No', 'Oo', 'Hindi', 0, 13),
(103, 12, '1', '1', 'Does the patient''s stomach hurt mostly when hungry?', 'Ang tiyan ba ng pasyente ay masakit lagi kapag gutom?', 'Yes', 'No', 'Oo', 'Hindi', 0, 13),
(104, 13, '1', '2', 'Does the patient''s stool have blood?', 'Meron bang dugo kapag dumudumi ang pasyente?', 'Yes', 'No', 'Meron', 'Wala', 18, 14),
(105, 13, '1', '2', 'Does the patient''s stool contain mucous?', 'Meron bang myukus kapag dumudumi ang pasyente?', 'Yes', 'No', 'Meron', 'Wala', 18, 14),
(106, 13, '1', '2', 'If patient is a child, Has the child passed worms in the last few weeks?', 'Kung ang pasyente ay bata, nakapasa ba ang bata sa "worms" sa nakaraang linggo?', 'Yes', 'No', 'Oo', 'Hindi', 18, 14),
(107, 13, '1', '2', 'If patient is a child, has the child experience waking up at night with itchy anus and mild stomach pains?', 'Kung ang pasyente ay bata, nagigising ba ang bata sa gabi na makati ang puwit at masakit ang tiyan?', 'Yes', 'No', 'Oo', 'Hindi', 18, 14),
(108, 13, '1', '2', 'If the patient is a child, does the child had worm medicine in the last three months?', 'Kung ang pasyente ay bata, napurga na ba ang bata nitong nakaraan na tatlong buwan?', 'Yes', 'No', 'Oo', 'Hindi', 18, 14),
(109, 14, '1', '2', 'Does the patient experience pain when urinating?', 'Masakit ba kapag umiihi ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 0, 15),
(110, 14, '1', '1', 'Does the patient urinate more frequently?', 'Madalas bang umihi ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 0, 15),
(111, 15, '1', '1', 'Has the patient had diarrhea more than three times today?', 'Ang pasyente ba ay nagdudumi ng mahigit sa tatlong beses ngayong araw?', 'Yes', 'No', 'Oo', 'Hindi', 16, 19),
(112, 15, '1', '1', 'Does the patient have watery stools?', 'Matubig ba ang pagdudumi ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 16, 19),
(113, 16, '1', '1', 'Is the patient very sleepy or tired?', 'Inaantok ba o masyadong pagod ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 0, 17),
(114, 16, '1', '1', 'Does the patient cannot drink (breastfeed if baby)?', 'Ang pasyente ba ay hindi umiinom (ayaw mag dede kapag sanggol)?', 'Yes', 'No', 'Oo', 'Hindi', 0, 17),
(115, 16, '1', '1', 'Does the skin of the patient do not return to it''s place in 2 seconds?', 'Hindi ba bumalik sa lugar ang balat ng pasyente pagkalipas ng dalawang segundo?', 'Yes', 'No', 'Oo', 'Hindi', 0, 17),
(116, 17, '1', '1', 'Is the patient irritable?', 'Mabilis ba mairita ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 18, 18),
(117, 17, '1', '1', 'Is the patient very thirsty?', 'Uhaw na uhaw ba ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 18, 18),
(118, 17, '1', '1', 'Is the patient always asking for water?', 'Parati ba humihingi ng tubig ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 18, 18),
(119, 18, '1', '1', 'Is there a lot of pain when the patient have diarrhea?', 'Nakakaranas ba ng sobrang sakit kapag dumudumi ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(120, 19, '1', '1', 'Does the patient have ear problems?', 'May problema ba sa tenga ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 20, 0),
(121, 19, '1', '1', 'Is the patient''s ear painful?', 'Masakit ba ang tenga ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 20, 0),
(122, 19, '1', '1', 'If the patient is a baby, is the baby pulling always pulling his/her ears?', 'Kung ang pasyente ay sanggol, lagi bang hinihila ng sanggol ang kanyang tenga?', 'Yes', 'No', 'Oo', 'Hindi', 20, 0),
(123, 19, '1', '2', 'Is there any water coming out of the patient''s ear?', 'Meron bang tubig na lumalabas sa tenga ng pasyente?', 'Yes', 'No', 'Meron', 'Wala', 20, 0),
(124, 20, '1', '1', 'If there is water coming out of the ear, how many days have the patient noticed it?', 'Kung may tubig na lumalabas sa sa tenga, ilang araw na napapansin ng pasyente ito?', '2 weeks or more', 'Less than 2 wee', 'Mahigit 2 linggo', 'Wala pang 2 linggo', 0, 21),
(125, 20, '1', '1', 'If there is water coming out of the ear, has the water coming out of the ear been on and off frequently in the past?', 'Kung may tubig na lumalabas sa tenga, madalas ba na pasulpot sulpot lang ito dati pa?', 'Yes', 'No', 'Oo', 'Hindi', 0, 21),
(126, 21, '1', '1', 'Is the ear of the patient painful and/or swollen around the ear, especially behind the ear?', 'Ang sakit ba na nararamdaman ng pasyente ay nasa paligid ng tenga lalo na sa likod ng tenga?', 'Yes', 'No', 'Oo', 'Hindi', 0, 22),
(127, 21, '1', '1', 'Is the ear of the patient only painful when the patient wiggle it?', 'Masakit ba ang tenga ng pasyente kapag ginagalaw niya ito?', 'Yes', 'No', 'Oo', 'Hindi', 0, 22),
(128, 22, '1', '1', 'Is this the first time the patient had problems with his/her ears? ', 'Ito ba ang unang beses magkaroon ng problema sa tenga ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(129, 23, '1', '1', 'Does the patient have a rash or other skin problem?', 'Meron bang problema sa balat ng pasyente?', 'Yes', 'No', 'Meron', 'Wala', 24, 31),
(130, 24, '1', '1', 'Are there any scaly areas in the skin of the patient that looked like it can be peeled off?', 'Meron bang parang kaliskis sa balat ng pasyente na pwedeng balatan?', 'Yes', 'No', 'Meron', 'Wala', 0, 25),
(131, 24, '1', '1', 'Is there any dried yellowish pus or other material around the skin of the patient?', 'Meron bang natuyong nana sa balat ng pasyente?', 'Yes', 'No', 'Meron', 'Wala', 0, 25),
(132, 25, '1', '1', 'Is there a swollen area in the skin of the patient?', 'Meron bang parte sa balat ng pasyente na namamaga?', 'Yes', 'No', 'Meron', 'Wala', 0, 26),
(133, 25, '1', '1', 'Is the area of the patient''s skin red?', 'Namumula ba ang balat ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 0, 26),
(134, 25, '1', '1', 'Is the infected area on the skin of the patient hotter than other areas?', 'Ang bahagi ng balat ng pasyente na may problema ay mainit kumpara ibang bahagi?', 'Yes', 'No', 'Oo', 'Hindi', 0, 26),
(135, 26, '1', '1', 'Is the skin problem of the patient very itchy?', 'Sobrang kati ba ng problema sa balat ng pasyente?', 'Yes', 'Not Very', 'Oo', 'Hindi', 27, 30),
(136, 27, '1', '1', 'Is the skin problem on the waistline or in between fingers?', 'Ang lokasyon ba ng pantal ay nasa mga tagong lugar tulad ng bewang o sa gitna ng mga daliri?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(137, 28, '1', '1', 'Is the skin of the patient slightly rough and itchy?', 'Ang balat ba ng pasyente ay medyo magaspang at makati?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(138, 28, '1', '1', 'Even if not very itchy, is the skin of the patient slightly rough and turning white?', 'Kahit na hindi sobrang makati, ang balat ba ng pasyente ay medyo magaspang at nagiging kulay puti?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(139, 29, '1', '1', 'Is the itchy area of the patient''s skin smooth?', 'Makinis ba ang makating bahagi ng balat ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(140, 29, '1', '1', 'Does the skin of the patient gets red easily if its scratched?', 'Madali bang mamula ang balat ng pasyente kapag kinamot?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(141, 29, '1', '1', 'Is the itchy area of the patient''s skin slightly raised (hives)?', 'Ang makating bahagi ba ng balat ng pasyente ay medyo nakaangat?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0),
(142, 30, '1', '1', 'Does the patient have a fever with the rash?', 'Ang pasyente ba ay may lagnat kasama ang pantal sa balat?', 'Yes', 'No', 'Meron', 'Wala', 0, 0),
(143, 30, '1', '1', 'Does the rash of the patient have little pockets of water?', 'Ang pantal ba ng pasyente ay may laman ng tubig sa loob?', 'Yes', 'No', 'Meron', 'Wala', 0, 0),
(144, 31, '1', '1', 'Does the patient have an eye problem?', 'May problema ba sa mata ng pasyente?', 'Yes', 'No', 'Meron', 'Wala', 32, 34),
(145, 32, '1', '1', 'Did the patient suddenly have a change in his/her vision?', 'Nagkaroon ba ng pagbabago sa paningin ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', -1, 33),
(146, 32, '1', '1', 'Is the eye of the patient painful without any clear reason?', 'Masakit ba ang mga mata ng pasyente ng walang rason?', 'Yes', 'No', 'Oo', 'Hindi', -1, 33),
(147, 32, '1', '1', 'If the eye of the patient is red, is the redness near the colored part?', 'Kung mapula ang mata ng pasyente, ang pagkapula ba ay malapit sa makulay na bahagi?', 'Yes', 'No', 'Oo', 'Hindi', -1, 33),
(148, 32, '1', '1', 'Is the eye of the patient swollen or like it''s protruding out?', 'Namamaga ba ang mga mata ng pasyente o parang lumuluwa?', 'Yes', 'No', 'Oo', 'Hindi', -1, 33),
(149, 32, '1', '1', 'Does the patient feel like there is something in the eye that doesn''t come out even though the tears have washed it?', 'Nararamdaman ba ng pasyente na parang may bagay sa kanyang mata na hindi matanggal kahit malinis ng luha?', 'Yes', 'No', 'Oo', 'Hindi', -1, 33),
(150, 33, '1', '1', 'Is there pus in the patient''s eye, or the eyes are red but the redness doesn''t touch the colored part?', 'Meron bang nana sa mata ng pasyente, o namumula ito pero ang pagkapula ay malayo sa makulay na bahagi ng mata?', 'Yes', 'No', 'Meron', 'Wala', 0, 0),
(151, 33, '1', '1', 'Is there a foreign body on the eye of the patient?', 'Meron bang nakikitang bagay na nasa mata ng pasyente?', 'Yes', 'No', 'Meron', 'Wala', 0, 0),
(152, 33, '1', '1', 'If patient is an adult and the eye is not painful, does the center black part of the patient''s eye hazy?', 'Kung ang pasyente ay matanda na at hindi masyado masakit ang mata, malabo ba o hindi masyadong maitim ang itim na bahagi sa gitna ng mata ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `intenttype`
--

CREATE TABLE IF NOT EXISTS `intenttype` (
  `intentTypeID` enum('1','2') NOT NULL,
  `intentType` varchar(20) NOT NULL,
  PRIMARY KEY (`intentTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `intenttype`
--

INSERT INTO `intenttype` (`intentTypeID`, `intentType`) VALUES
('1', 'positive'),
('2', 'negative');

-- --------------------------------------------------------

--
-- Table structure for table `questionanswer`
--

CREATE TABLE IF NOT EXISTS `questionanswer` (
  `ID` int(11) NOT NULL,
  `answerID` int(11) NOT NULL,
  PRIMARY KEY (`ID`,`answerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `steptype`
--

CREATE TABLE IF NOT EXISTS `steptype` (
  `step` int(11) NOT NULL,
  `categoryID` int(11) NOT NULL,
  PRIMARY KEY (`step`,`categoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `steptype`
--

INSERT INTO `steptype` (`step`, `categoryID`) VALUES
(1, 1),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 3),
(7, 3),
(8, 3),
(9, 4),
(10, 4),
(11, 4),
(12, 4),
(13, 4),
(14, 4),
(15, 5),
(16, 5),
(17, 5),
(18, 5),
(19, 6),
(20, 6),
(21, 6),
(22, 6),
(23, 7),
(24, 7),
(25, 7),
(26, 7),
(27, 7),
(28, 7),
(29, 7),
(30, 7),
(31, 8),
(32, 8),
(33, 8);

-- --------------------------------------------------------

--
-- Table structure for table `texttype`
--

CREATE TABLE IF NOT EXISTS `texttype` (
  `textTypeID` enum('1','2','3') NOT NULL,
  `textType` varchar(15) NOT NULL,
  PRIMARY KEY (`textTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `texttype`
--

INSERT INTO `texttype` (`textTypeID`, `textType`) VALUES
('1', 'question'),
('2', 'reply'),
('3', 'instruction');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inputtext`
--
ALTER TABLE `inputtext`
  ADD CONSTRAINT `inputtext_ibfk_1` FOREIGN KEY (`textTypeID`) REFERENCES `texttype` (`textTypeID`),
  ADD CONSTRAINT `inputtext_ibfk_2` FOREIGN KEY (`intentTypeID`) REFERENCES `intenttype` (`intentTypeID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
