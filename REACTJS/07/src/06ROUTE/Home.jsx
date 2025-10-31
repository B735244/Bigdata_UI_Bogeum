import { Link } from "react-router-dom"

const Home = () => {
    return (
        <>
            <nav>
                <ul>
                    <li> <Link to="/">HOME</Link>           </li>
                    <li> <Link to="/about?name=timo&age=100">ABOUT_1</Link> </li>
                    <li> <Link to="/about?name=yumi&age=50">ABOUT_2</Link>     </li>
                    <li> <Link to="/contact/jung/40">CONTACT</Link> </li>
                </ul>
            </nav>
            <h1>Home PAGE</h1>

        </>
    )
}

export default Home;