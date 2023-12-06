const Card = ({ data }) => {
  return (
    <li>
      <figure>
        <img src={data.imgUrl} alt={data.name} />
        <div className="info">
          <span>{data.name}</span>
          <span>{data.country}</span>
        </div>
      </figure>
    </li>
  )
}

export default Card