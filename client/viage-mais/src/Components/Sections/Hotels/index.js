import hotels from '@/constants/hotels.json'
import Card from './Components/Card'

const Hotels = () => {
  return (
    <section className="hotels" id="hotels">
      <div className="titles">
        <div>
          <span>Hóteis</span>
          <div className="wrapper">
            <h2>Escolha a sua estadia</h2>
            <p>Verifique hotéis indicados!</p>
          </div>
        </div>
      </div>
      <ul>
        <li>Rio de Janeiro</li>
        <li>Londres</li>
        <li>Dubai</li>
        <li>Salvador</li>
        <li>Lisboa</li>
        <li>Peru</li>
        <li>México</li>
      </ul>
      <div className="cards">
        {hotels && hotels.map(hotel => <Card data={hotel} />)}
      </div>
    </section>
  )
}

export default Hotels